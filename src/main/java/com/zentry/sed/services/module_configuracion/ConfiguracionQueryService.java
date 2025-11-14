package com.zentry.sed.services.module_configuracion;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.zentry.sed.core.repositories.module_roles.IRolRepository;
import com.zentry.sed.core.repositories.module_usuarios.IEstadoUsuarioRepository;

@Service
public class ConfiguracionQueryService {
    
    private final IRolRepository rolRepository;
    private final IEstadoUsuarioRepository estadoUsuarioRepository;

    public ConfiguracionQueryService(
        IRolRepository rolRepository , 
        IEstadoUsuarioRepository estadoUsuarioRepository
    ){
        this.rolRepository = rolRepository;
        this.estadoUsuarioRepository = estadoUsuarioRepository;
    }

    public Map<String , List<String>> sendDataForRegister(){
        
        List<String> listRolesId = rolRepository.findAll()
            .stream()
            .map(r -> r.getId())
            .collect(Collectors.toList());

        List<String> listEstadosUsuarioId = estadoUsuarioRepository.findAll()
            .stream()
            .map(eu -> eu.getId())
            .collect(Collectors.toList());

        return Map.of(
            "RolesId" , listRolesId , 
            "EstadosUsuarioId", listEstadosUsuarioId
        );
    }
}
