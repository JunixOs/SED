package com.zentry.sed.core.entities.module_core;

public class EstadoMatriculaDomainEntity {
    private String id;
    private String codigo;
    private String etiqueta;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEtiqueta() {
        return etiqueta;
    }
    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }
}
