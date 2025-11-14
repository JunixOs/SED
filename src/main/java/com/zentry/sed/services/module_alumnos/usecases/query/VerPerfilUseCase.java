package com.zentry.sed.services.module_alumnos.usecases.query;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.zentry.sed.core.entities.module_usuarios.UsuarioDomainEntity;
import com.zentry.sed.core.repositories.module_alumnos.IEstudianteRepository;
import com.zentry.sed.core.repositories.module_usuarios.IEstadoUsuarioRepository;
import com.zentry.sed.core.repositories.module_usuarios.IUsuarioRepository;

@Component
public class VerPerfilUseCase {

    private final IUsuarioRepository usuarioRepository;
    private final IEstudianteRepository estudianteRepository;
    private final IEstadoUsuarioRepository estadoUsuarioRepository;

    public VerPerfilUseCase(
        IUsuarioRepository usuarioRepository , 
        IEstudianteRepository estudianteRepository,
        IEstadoUsuarioRepository estadoUsuarioRepository
    ){
        this.usuarioRepository = usuarioRepository;
        this.estudianteRepository = estudianteRepository;
        this.estadoUsuarioRepository = estadoUsuarioRepository;
    }

    public List<Object> execute(String usuarioId){
        List<Object> dataFromUser = new ArrayList<>();

        UsuarioDomainEntity usuarioDomainEntity = usuarioRepository.findById(usuarioId).orElse(null);

        dataFromUser.add(
            usuarioDomainEntity
        );
        dataFromUser.add(
            estudianteRepository.findByUsuarioId(usuarioId)
        );
        dataFromUser.add(
            estadoUsuarioRepository.findById(usuarioDomainEntity.getEstadoUsuarioDomainEntity().getId())
        );

        return dataFromUser;
    }

    // completar y añadir en core para alumno y curso
}