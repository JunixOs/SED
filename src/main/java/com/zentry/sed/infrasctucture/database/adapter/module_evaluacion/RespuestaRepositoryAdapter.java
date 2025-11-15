package com.zentry.sed.infrasctucture.database.adapter.module_evaluacion;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.zentry.sed.core.entities.module_evaluacion.PreguntaDomainEntity;
import com.zentry.sed.core.entities.module_evaluacion.RespuestaDomainEntity;
import com.zentry.sed.core.repositories.module_evaluacion.IRespuestaRepository;
import com.zentry.sed.infrasctucture.database.entities.module_evaluacion.EvaluacionEntity;
import com.zentry.sed.infrasctucture.database.entities.module_evaluacion.PreguntaEntity;
import com.zentry.sed.infrasctucture.database.mappers.module_evaluacion.PreguntaMapper;
import com.zentry.sed.infrasctucture.database.mappers.module_evaluacion.RespuestaMapper;
import com.zentry.sed.infrasctucture.repositories.module_evaluacion.EvaluacionJPARepository;
import com.zentry.sed.infrasctucture.repositories.module_evaluacion.PreguntaJPARepository;
import com.zentry.sed.infrasctucture.repositories.module_evaluacion.RespuestaJPARepository;

@Repository
public class RespuestaRepositoryAdapter implements IRespuestaRepository {
    
    private final RespuestaJPARepository respuestaJPARepository;
    private final EvaluacionJPARepository evaluacionJPARepository;
    private final PreguntaJPARepository preguntaJPARepository;

    public RespuestaRepositoryAdapter(
        RespuestaJPARepository respuestaJPARepository , 
        EvaluacionJPARepository evaluacionJPARepository , 
        PreguntaJPARepository preguntaJPARepository
    ){
        this.respuestaJPARepository = respuestaJPARepository;
        this.evaluacionJPARepository = evaluacionJPARepository;
        this.preguntaJPARepository = preguntaJPARepository;
    }

    public Optional<RespuestaDomainEntity> findById(String id){
        return respuestaJPARepository.findById(UUID.fromString(id))
            .map(r -> RespuestaMapper.toDomain(r));
    }

    public void save(RespuestaDomainEntity respuestaDomainEntity){
        
        EvaluacionEntity evaluacionEntity = evaluacionJPARepository.findById(
            UUID.fromString(respuestaDomainEntity.getEvaluacionId())
        ).orElse(null);

        PreguntaEntity preguntaEntity = preguntaJPARepository.findById(
            UUID.fromString(respuestaDomainEntity.getPreguntaId())
        ).orElse(null);
        
        respuestaJPARepository.save(
            RespuestaMapper.toEntitiy(
                respuestaDomainEntity, 
                evaluacionEntity, 
                preguntaEntity
            )
        );
    }

    public List<PreguntaDomainEntity> findAllPreguntasByEvaluacionId(String evaluacionId){
        return respuestaJPARepository.findAllPreguntasByEvaluacion_Id(UUID.fromString(evaluacionId))
            .stream()
            .map(PreguntaMapper::toDomain)
            .collect(Collectors.toList());
    }

    public void saveAll(List<RespuestaDomainEntity> listRespuestaDomainEntities){
        respuestaJPARepository.saveAll(
            listRespuestaDomainEntities.stream()
                .map(r -> {
                    EvaluacionEntity evaluacionEntity = evaluacionJPARepository.findById(UUID.fromString(r.getEvaluacionId())).orElse(null);
                    PreguntaEntity preguntaEntity = preguntaJPARepository.findById(UUID.fromString(r.getPreguntaId())).orElse(null);
                    
                    return RespuestaMapper.toEntitiy(
                        r, 
                        evaluacionEntity, 
                        preguntaEntity
                    );
                })
                .collect(Collectors.toList())
        );
    }
}