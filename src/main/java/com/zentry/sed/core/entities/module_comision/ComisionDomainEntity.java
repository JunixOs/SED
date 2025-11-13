package com.zentry.sed.core.entities.module_comision;

public class ComisionDomainEntity {
    private String id;
    private String usuarioId;
    private String facultad;
    private String periodoId;
    private String rolMiembro;

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

    public String getFacultad() {
        return facultad;
    }
    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getPeriodoId() {
        return periodoId;
    }
    public void setPeriodoId(String periodoId) {
        this.periodoId = periodoId;
    }

    public String getRolMiembro() {
        return rolMiembro;
    }
    public void setRolMiembro(String rolMiembro) {
        this.rolMiembro = rolMiembro;
    }

    public static ComisionDomainEntity create(
        String usuarioId,
        String facultad,
        String periodoId,
        String rolMiembro
    ){
        ComisionDomainEntity comisionDomainEntity = new ComisionDomainEntity();

        comisionDomainEntity.setUsuarioId(usuarioId);
        comisionDomainEntity.setFacultad(facultad);
        comisionDomainEntity.setPeriodoId(periodoId);
        comisionDomainEntity.setRolMiembro(rolMiembro);

        return comisionDomainEntity;
    }
}
