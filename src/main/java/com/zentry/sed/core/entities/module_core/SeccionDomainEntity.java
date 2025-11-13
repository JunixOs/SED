package com.zentry.sed.core.entities.module_core;

public class SeccionDomainEntity {
    private String id;
    private CursoDomainEntity cursoDomainEntitiy;
    private String periodoId;
    private String codigoSeccion; 
    private ModalidadSeccionDomainEntity modalidadSeccionDomainEntity;
    private String docenteId;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public CursoDomainEntity getCursoDomainEntitiy() {
        return cursoDomainEntitiy;
    }
    public void setCursoDomainEntitiy(CursoDomainEntity cursoDomainEntitiy) {
        this.cursoDomainEntitiy = cursoDomainEntitiy;
    }

    public String getPeriodoId() {
        return periodoId;
    }
    public void setPeriodoId(String periodoId) {
        this.periodoId = periodoId;
    }

    public String getCodigoSeccion() {
        return codigoSeccion;
    }
    public void setCodigoSeccion(String codigoSeccion) {
        this.codigoSeccion = codigoSeccion;
    }

    public ModalidadSeccionDomainEntity getModalidadSeccionDomainEntity() {
        return modalidadSeccionDomainEntity;
    }
    public void setModalidadSeccionDomainEntity(ModalidadSeccionDomainEntity modalidadSeccionDomainEntity) {
        this.modalidadSeccionDomainEntity = modalidadSeccionDomainEntity;
    }

    public String getDocenteId() {
        return docenteId;
    }
    public void setDocenteId(String docenteId) {
        this.docenteId = docenteId;
    }
}
