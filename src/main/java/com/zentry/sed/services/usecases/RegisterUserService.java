package com.zentry.sed.services.usecases;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zentry.sed.core.entities.module_roles.RolDomainEntity;
import com.zentry.sed.core.repositories.module_roles.IRolRepository;
import com.zentry.sed.services.interfaces.IRegisterUserService;

@Service
public class RegisterUserService implements IRegisterUserService {
    
    private final IRolRepository rolRepository; // Spring va a inyectar el adaptador RolRepositoryAdapter porque implementa IRolRepository

    public RegisterUserService(IRolRepository rolRepository){
        this.rolRepository = rolRepository;
    }

    @Override
    public List<RolDomainEntity> findAllRoles(){
        return this.rolRepository.findAll();
    }

    @Override
    public void register(){
        
    }
}
