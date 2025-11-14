package com.zentry.sed.presentation.models.mappers;

import com.zentry.sed.core.entities.module_core.CursoDomainEntity;
import com.zentry.sed.presentation.models.responseDTO.module_alumnos.VerCursosPorSemestreResponseDTO;

public class VerCursosPorSemestreMapper {
    public static VerCursosPorSemestreResponseDTO domaintoResponse(CursoDomainEntity cursoDomainEntity){
        VerCursosPorSemestreResponseDTO verCursosPorSemestreResponseDTO = new VerCursosPorSemestreResponseDTO();

        verCursosPorSemestreResponseDTO.setIdCurso(cursoDomainEntity.getId());
        verCursosPorSemestreResponseDTO.setNombreCurso(cursoDomainEntity.getNombre());
        verCursosPorSemestreResponseDTO.setFacultadCurso(cursoDomainEntity.getFacultad());
        verCursosPorSemestreResponseDTO.setCreditosCurso(cursoDomainEntity.getCreditos());

        return verCursosPorSemestreResponseDTO;
    }
}
