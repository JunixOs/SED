package com.zentry.sed.core.entities.module_evaluacion;

public class EvaluacionDomainEntity {
    private String id;
    private String creadaEn;
    private EstadoEvaluacionDomainEntity estadoEvaluacionDomainEntity;
    
    private String docenteId;
    private String instrumentoId;
    private String matriculaId;

    private String tokenAnonimo;
    private CanalDomainEntity canalDomainEntity;

    private String comentarioGeneral;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getCreadaEn() {
        return creadaEn;
    }
    public void setCreadaEn(String creadaEn) {
        this.creadaEn = creadaEn;
    }

    public EstadoEvaluacionDomainEntity getEstadoEvaluacionDomainEntity() {
        return estadoEvaluacionDomainEntity;
    }
    public void setEstadoEvaluacionDomainEntity(EstadoEvaluacionDomainEntity estadoEvaluacionDomainEntity) {
        this.estadoEvaluacionDomainEntity = estadoEvaluacionDomainEntity;
    }

    public String getDocenteId() {
        return docenteId;
    }
    public void setDocenteId(String docenteId) {
        this.docenteId = docenteId;
    }

    public String getInstrumentoId() {
        return instrumentoId;
    }
    public void setInstrumentoId(String instrumentoId) {
        this.instrumentoId = instrumentoId;
    }

    public String getMatriculaId() {
        return matriculaId;
    }
    public void setMatriculaId(String matriculaId) {
        this.matriculaId = matriculaId;
    }

    public String getTokenAnonimo() {
        return tokenAnonimo;
    }
    public void setTokenAnonimo(String tokenAnonimo) {
        this.tokenAnonimo = tokenAnonimo;
    }

    public CanalDomainEntity getCanalDomainEntity() {
        return canalDomainEntity;
    }
    public void setCanalDomainEntity(CanalDomainEntity canalDomainEntity) {
        this.canalDomainEntity = canalDomainEntity;
    }

    public String getComentarioGeneral() {
        return comentarioGeneral;
    } 
    public void setComentarioGeneral(String comentarioGeneral) {
        this.comentarioGeneral = comentarioGeneral;
    }
}
