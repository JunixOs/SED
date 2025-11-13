package com.zentry.sed.core.entities.module_alumnos;

public class EstudianteDomainEntity {
    private String id;
    private String usuarioId;

    private String semestre;
    private String carrera;
    private String codigoEstudiante;

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

    public String getSemestre() {
        return semestre;
    }
    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getCarrera() {
        return carrera;
    }
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }
    public void setCodigoEstudiante(String codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public static EstudianteDomainEntity create(
        String usuarioId,
        String semestre,
        String carrera,
        String codigoEstudiante
    ) {
        EstudianteDomainEntity estudianteDomainEntity = new EstudianteDomainEntity();

        estudianteDomainEntity.setUsuarioId(usuarioId);
        estudianteDomainEntity.setSemestre(semestre);
        estudianteDomainEntity.setCarrera(carrera);
        estudianteDomainEntity.setCodigoEstudiante(codigoEstudiante);

        return estudianteDomainEntity;
    }
}
