package com.zentry.sed.core.entities.module_docentes;

public class DocenteDomainEntity {
    private String id;
    private String usuarioId;
    private String departamento;
    private Integer antiguedad;
    private String gradoAcademico;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getUsuarioId() {
        return usuarioId;
    }
    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getDepartamento() {
        return departamento;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Integer getAntiguedad() {
        return antiguedad;
    }
    public void setAntiguedad(Integer antiguedad) {
        this.antiguedad = antiguedad;
    }
    
    public String getGradoAcademico() {
        return gradoAcademico;
    }
    public void setGradoAcademico(String gradoAcademico) {
        this.gradoAcademico = gradoAcademico;
    }

    public static DocenteDomainEntity create(
        String usuarioId,
        String departamento,
        Integer antiguedad,
        String gradoAcademico
    ){
        DocenteDomainEntity docenteDomainEntity = new DocenteDomainEntity();

        docenteDomainEntity.setUsuarioId(usuarioId);
        docenteDomainEntity.setDepartamento(departamento);
        docenteDomainEntity.setAntiguedad(antiguedad);
        docenteDomainEntity.setGradoAcademico(gradoAcademico);

        return docenteDomainEntity;
    }
}
