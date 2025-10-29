package com.zentry.sed.core.entities.module_comision;

public class ComisionDomainEntity {
    private String facultad;
    private String periodoId;
    private String rolMiembro;

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
}
