package com.zentry.sed.infrasctucture.database.adapter.module_core;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.zentry.sed.core.entities.module_core.SeccionDomainEntity;
import com.zentry.sed.core.repositories.module_core.ISeccionRepository;
import com.zentry.sed.infrasctucture.database.entities.module_core.CursoEntity;
import com.zentry.sed.infrasctucture.database.entities.module_core.ModalidadSeccionEntity;
import com.zentry.sed.infrasctucture.database.entities.module_core.PeriodoEntity;
import com.zentry.sed.infrasctucture.database.entities.module_docentes.DocenteEntity;
import com.zentry.sed.infrasctucture.database.mappers.module_core.SeccionMapper;
import com.zentry.sed.infrasctucture.repositories.module_core.CursoJPARepository;
import com.zentry.sed.infrasctucture.repositories.module_core.ModalidadSeccionJPARepository;
import com.zentry.sed.infrasctucture.repositories.module_core.PeriodoJPARepository;
import com.zentry.sed.infrasctucture.repositories.module_core.SeccionJPARepository;
import com.zentry.sed.infrasctucture.repositories.module_docentes.DocenteJPARepository;

@Repository
public class SeccionRepositoryAdapter implements ISeccionRepository {

    private final SeccionJPARepository seccionJPARepository;
    
    private final CursoJPARepository cursoJPARepository;
    private final PeriodoJPARepository periodoJPARepository;
    private final ModalidadSeccionJPARepository modalidadSeccionJPARepository;
    private final DocenteJPARepository docenteJPARepository;

    public SeccionRepositoryAdapter(
        SeccionJPARepository seccionJPARepository, 
        CursoJPARepository cursoJPARepository ,
        PeriodoJPARepository periodoJPARepository , 
        ModalidadSeccionJPARepository modalidadSeccionJPARepository,
        DocenteJPARepository docenteJPARepository
    ){
        this.seccionJPARepository = seccionJPARepository;
        this.cursoJPARepository = cursoJPARepository;
        this.periodoJPARepository = periodoJPARepository;
        this.modalidadSeccionJPARepository = modalidadSeccionJPARepository;
        this.docenteJPARepository = docenteJPARepository;
    }

    public List<String> findAllCursoIdById(List<String> id){
        return seccionJPARepository.findAllCursoIdById(
                id.stream()
                .map(UUID::fromString)
                .collect(Collectors.toList())
            )
            .stream()
            .map(UUID::toString)
            .collect(Collectors.toList());
    }

    public Optional<SeccionDomainEntity> findById(String id){
        return seccionJPARepository.findById(UUID.fromString(id))
            .map(s -> SeccionMapper.toDomain(s));
    }

    public void save(SeccionDomainEntity seccionDomainEntity){
        
        CursoEntity cursoEntity = cursoJPARepository.findById(
            UUID.fromString(seccionDomainEntity.getCursoDomainEntitiy().getId())
        ).orElse(null);

        PeriodoEntity periodoEntity = periodoJPARepository.findById(
            UUID.fromString(seccionDomainEntity.getPeriodoId())
        ).orElse(null);

        ModalidadSeccionEntity modalidadSeccionEntity = modalidadSeccionJPARepository.findById(
            UUID.fromString(seccionDomainEntity.getModalidadSeccionDomainEntity().getId())
        ).orElse(null);

        DocenteEntity docenteEntity = docenteJPARepository.findById(
            UUID.fromString(seccionDomainEntity.getDocenteId())
        ).orElse(null);

        seccionJPARepository.save(
            SeccionMapper.toEntity(
                seccionDomainEntity,
                cursoEntity,
                periodoEntity,
                modalidadSeccionEntity,
                docenteEntity
            )
        );
    }

    public void deleteById(String id){
        seccionJPARepository.deleteById(UUID.fromString(id));
    }
}
