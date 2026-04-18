package com.zentry.sed.services.module_alumnos.usecases.query;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.zentry.sed.core.entities.module_alumnos.EstudianteDomainEntity;
import com.zentry.sed.core.entities.module_usuarios.UsuarioDomainEntity;
import com.zentry.sed.core.repositories.module_alumnos.IEstudianteRepository;
import com.zentry.sed.core.repositories.module_usuarios.IUsuarioRepository;

@Component
public class SendDataForIndexPageUseCase {
    
    private final IUsuarioRepository usuarioRepository;
    private final IEstudianteRepository estudianteRepository;

    public SendDataForIndexPageUseCase(
        IUsuarioRepository usuarioRepository,
        IEstudianteRepository estudianteRepository
    ){
        this.usuarioRepository = usuarioRepository;
        this.estudianteRepository = estudianteRepository;
    }

    public Map<String , String> execute(String usuarioId) throws IOException{

        UsuarioDomainEntity usuarioDomainEntity = usuarioRepository.findById(usuarioId).orElse(null);

        EstudianteDomainEntity estudianteDomainEntity = estudianteRepository.findByUsuarioId(usuarioId).orElse(null);

        if (usuarioDomainEntity == null || estudianteDomainEntity == null) {
            throw new IOException();
        }

        return Map.of(
            "usuarioNombreCompletos", usuarioDomainEntity.getNombreCompleto() , 
            "Usuariocorreo" , usuarioDomainEntity.getCorreo(),
            "estudianteSemestre", estudianteDomainEntity.getSemestre() , 
            "estudianteCarrera", estudianteDomainEntity.getCarrera() , 
            "estudianteCodigoEstudiante" , estudianteDomainEntity.getCodigoEstudiante()
        );
    }

}
