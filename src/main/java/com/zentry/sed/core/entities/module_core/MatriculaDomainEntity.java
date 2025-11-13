package com.zentry.sed.core.entities.module_core;

import java.time.LocalDateTime;

public class MatriculaDomainEntity {
    private LocalDateTime fechaMatricula;
    private EstadoMatriculaDomainEntity estadoMatriculaDomainEntity;
    private String seccionId;
    private String estudianteId;

    public LocalDateTime getFechaMatricula() {
        return fechaMatricula;
    }
    public void setFechaMatricula(LocalDateTime fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public EstadoMatriculaDomainEntity getEstadoMatriculaDomainEntity() {
        return estadoMatriculaDomainEntity;
    }
    public void setEstadoMatriculaDomainEntity(EstadoMatriculaDomainEntity estadoMatriculaDomainEntity) {
        this.estadoMatriculaDomainEntity = estadoMatriculaDomainEntity;
    }

    public String getSeccionId() {
        return seccionId;
    }
    public void setSeccionId(String seccionId) {
        this.seccionId = seccionId;
    }

    public String getEstudianteId() {
        return estudianteId;
    }
    public void setEstudianteId(String estudianteId) {
        this.estudianteId = estudianteId;
    }
}
