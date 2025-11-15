package com.zentry.sed.core.entities.module_evaluacion;

public class RespuestaDomainEntity {
    private String id;
    private String evaluacionId;
    private String preguntaId;
    private Integer valor;
    private String comentario;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getEvaluacionId() {
        return evaluacionId;
    }
    public void setEvaluacionId(String evaluacionId) {
        this.evaluacionId = evaluacionId;
    }

    public String getPreguntaId() {
        return preguntaId;
    }
    public void setPreguntaId(String preguntaId) {
        this.preguntaId = preguntaId;
    }

    public Integer getValor() {
        return valor;
    }
    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getComentario() {
        return comentario;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
