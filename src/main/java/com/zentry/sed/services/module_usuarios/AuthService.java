package com.zentry.sed.services.module_usuarios;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.zentry.sed.core.entities.module_alumnos.EstudianteDomainEntity;
import com.zentry.sed.core.entities.module_comision.ComisionDomainEntity;
import com.zentry.sed.core.entities.module_docentes.DocenteDomainEntity;
import com.zentry.sed.core.entities.module_usuarios.UsuarioDomainEntity;
import com.zentry.sed.core.repositories.module_alumnos.IEstudianteRepository;
import com.zentry.sed.core.repositories.module_comision.IComisionRepository;
import com.zentry.sed.core.repositories.module_docentes.IDocenteRepository;
import com.zentry.sed.core.repositories.module_usuarios.IEstadoUsuarioRepository;
import com.zentry.sed.core.repositories.module_usuarios.IUsuarioRepository;
import com.zentry.sed.core.repositories.module_usuarios.IUsuarioRolRepository;
import com.zentry.sed.presentation.models.requestDTO.module_configuracion.RegistrarComisionRequestDTO;
import com.zentry.sed.presentation.models.requestDTO.module_configuracion.RegistrarDocenteRequestDTO;
import com.zentry.sed.presentation.models.requestDTO.module_configuracion.RegistrarEstudianteRequestDTO;
import com.zentry.sed.presentation.models.requestDTO.module_configuracion.RegistrarUsuarioAbsClass;
import com.zentry.sed.security.JwtUtil;

@Service
public class AuthService {

    private final IUsuarioRepository usuarioRepository;
    private final IUsuarioRolRepository usuarioRolRepository;
    private final IEstadoUsuarioRepository estadoUsuarioRepository;

    private final IEstudianteRepository estudianteRepository;
    private final IDocenteRepository docenteRepository;
    private final IComisionRepository comisionRepository;

    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthService(
        IUsuarioRepository usuarioRepository,
        IUsuarioRolRepository usuarioRolRepository,
        IEstadoUsuarioRepository estadoUsuarioRepository,

        IEstudianteRepository estudianteRepository,
        IDocenteRepository docenteRepository,
        IComisionRepository comisionRepository,

        PasswordEncoder passwordEncoder,
        JwtUtil jwtUtil
    ){
        this.usuarioRepository = usuarioRepository;
        this.usuarioRolRepository = usuarioRolRepository;
        this.estadoUsuarioRepository = estadoUsuarioRepository;

        this.estudianteRepository = estudianteRepository;
        this.docenteRepository = docenteRepository;
        this.comisionRepository = comisionRepository;

        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public String register(
        RegistrarUsuarioAbsClass registrarUsuarioRequestDTO
    ) throws IOException{

        UsuarioDomainEntity usuarioDomainEntity = UsuarioDomainEntity.create(
            registrarUsuarioRequestDTO.getNombreCompleto() ,
            registrarUsuarioRequestDTO.getCorreo() ,
            passwordEncoder.encode(registrarUsuarioRequestDTO.getPassword()) , 
            estadoUsuarioRepository.findById(registrarUsuarioRequestDTO.getEstadoUsuarioId()).orElse(null)
        );

        usuarioRepository.save(usuarioDomainEntity);

        String registeredUsuarioId = usuarioRepository.findByCorreo(registrarUsuarioRequestDTO.getCorreo()).map(id -> id.toString()).orElse(null);

        if (registeredUsuarioId == null) {
            throw new IOException(); // Siempre debes especificar que la funciona puede arrojar un error
        }

        for(String rolId : registrarUsuarioRequestDTO.getRolId()){
            usuarioRolRepository.save(
                registeredUsuarioId , 
                rolId
            );
        }

        if(registrarUsuarioRequestDTO instanceof RegistrarEstudianteRequestDTO RegEst){
            EstudianteDomainEntity estudianteDomainEntity = EstudianteDomainEntity.create(
                registeredUsuarioId , 
                RegEst.getSemestre() , 
                RegEst.getCarrera() , 
                RegEst.getCodigoEstudiante()
            );
            
            estudianteRepository.save(estudianteDomainEntity);

        } else if (registrarUsuarioRequestDTO instanceof RegistrarDocenteRequestDTO RegDoc) {
            DocenteDomainEntity docenteDomainEntity = DocenteDomainEntity.create(
                registeredUsuarioId , 
                RegDoc.getDepartamento() , 
                RegDoc.getAntiguedad() , 
                RegDoc.getGradoAcademico()
            );

            docenteRepository.save(docenteDomainEntity);

        } else if (registrarUsuarioRequestDTO instanceof RegistrarComisionRequestDTO RegComm) {
            ComisionDomainEntity comisionDomainEntity = ComisionDomainEntity.create(
                registeredUsuarioId, 
                RegComm.getFacultad(), 
                RegComm.getPeriodoId(),
                RegComm.getRolMiembro()
            );

            comisionRepository.save(comisionDomainEntity);
        }

        return "Usuario registrado con exito.";
    }

    public String login(String correo , String password){
        var usuario = usuarioRepository.findByCorreo(correo)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if(!passwordEncoder.matches(password , usuario.getPasswordHash())){
            throw new RuntimeException("Contrasñea incorrecta.");
        }

        List<String> roles = usuarioRolRepository.findAllRolByUsuarioId(usuario.getId())
            .stream()
            .map(r -> r.getNombre())
            .collect(Collectors.toList());

        return jwtUtil.generateToken(password, roles);
    }
}
