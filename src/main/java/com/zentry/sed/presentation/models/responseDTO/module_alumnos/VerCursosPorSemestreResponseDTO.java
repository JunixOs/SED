package com.zentry.sed.presentation.models.responseDTO.module_alumnos;

public class VerCursosPorSemestreResponseDTO {
    private String idCurso;
    private String nombreCurso;
    private String codigoCurso;
    private String facultadCurso;
    private Integer creditosCurso;

    public String getIdCurso() {
        return idCurso;
    }
    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }
    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }
    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getFacultadCurso() {
        return facultadCurso;
    }
    public void setFacultadCurso(String facultadCurso) {
        this.facultadCurso = facultadCurso;
    }

    public Integer getCreditosCurso() {
        return creditosCurso;
    }
    public void setCreditosCurso(Integer creditosCurso) {
        this.creditosCurso = creditosCurso;
    }
}
