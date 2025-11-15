package com.zentry.sed.core.entities.module_evaluacion;

import java.math.BigDecimal;

public class PreguntaDomainEntity {
    private String id;
    private String moduloId;
    
    private CriterioDomainEntity criterioDomainEntity;

    private String enunciado;
    private Integer orden;

    private BigDecimal pesoPregunta;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getModuloId() {
        return moduloId;
    }
    public void setModuloId(String moduloId) {
        this.moduloId = moduloId;
    }

    public CriterioDomainEntity getCriterioDomainEntity() {
        return criterioDomainEntity;
    }
    public void setCriterioDomainEntity(CriterioDomainEntity criterioDomainEntity) {
        this.criterioDomainEntity = criterioDomainEntity;
    }

    public String getEnunciado() {
        return enunciado;
    }
    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public Integer getOrden() {
        return orden;
    }
    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public BigDecimal getPesoPregunta() {
        return pesoPregunta;
    }
    public void setPesoPregunta(BigDecimal pesoPregunta) {
        this.pesoPregunta = pesoPregunta;
    }
}
