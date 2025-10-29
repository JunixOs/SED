package com.zentry.sed.services.usecases;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.zentry.sed.core.entities.module_roles.RolDomainEntity;
import com.zentry.sed.core.entities.module_usuarios.UsuarioDomainEntity;
import com.zentry.sed.core.repositories.module_roles.IRolRepository;
import com.zentry.sed.core.repositories.module_usuarios.IUsuarioRepository;
import com.zentry.sed.services.exceptions.LoginUserException;
import com.zentry.sed.services.interfaces.ILoginUserService;

@Service
public class LoginUserService implements ILoginUserService{
    
    private final IUsuarioRepository usuarioRepository; // Spring va a inyectar el adaptador usuarioRepositoryAdapter porque implementa IUsuarioRepository
    private final IRolRepository rolRepository;

    private final PasswordEncoder passwordEncoder; // Esto viene de config/ y permite hasheo de contraseñas

    public LoginUserService(IUsuarioRepository usuarioRepository , IRolRepository rolRepository , PasswordEncoder passwordEncoder){
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<UsuarioDomainEntity> login(String correo , String password){
        List<UsuarioDomainEntity> usersInDb = this.usuarioRepository.findAll();
        if(usersInDb.isEmpty()){
            throw new LoginUserException("No se encontraron usuarios, contactese con los administradores.");
        }

        UsuarioDomainEntity userFounded = usersInDb.stream()
            .filter(u -> u.getCorreo().equals(correo))
            .findFirst()
            .orElseThrow(() -> new LoginUserException("El correo ingresado es incorrecto."));
    
        if(!this.passwordEncoder.matches(password, userFounded.getPasswordHash())){
            throw new LoginUserException("La contraseña especificada es incorrecta.");
        }

        Optional<RolDomainEntity> rolFoundedUser = this.rolRepository.findById(userFounded.getRolId());

        switch (rolFoundedUser.get().getNombre().toUpperCase()) {
            case "COMISION":
                
            break;

            case "ALUMNO":

            break;
            case "DOCENTE":

            break;

        }

        return Optional.of(userFounded);
    }
}
