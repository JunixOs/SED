package com.zentry.sed.core.entities.module_core;

import java.time.LocalDate;

public class PeriodoDomainEntity {
    private String id;
    private Integer anio;
    private String termino;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private EstadoPeriodoDomainEntity estadoPeriodoDomainEntity;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public Integer getAnio() {
        return anio;
    }
    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getTermino() {
        return termino;
    }
    public void setTermino(String termino) {
        this.termino = termino;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public EstadoPeriodoDomainEntity getEstadoPeriodoDomainEntity() {
        return estadoPeriodoDomainEntity;
    }
    public void setEstadoPeriodoDomainEntity(EstadoPeriodoDomainEntity estadoPeriodoDomainEntity) {
        this.estadoPeriodoDomainEntity = estadoPeriodoDomainEntity;
    }
}
