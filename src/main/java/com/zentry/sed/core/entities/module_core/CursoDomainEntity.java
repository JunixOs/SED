package com.zentry.sed.core.entities.module_core;

public class CursoDomainEntity {
    private String id;
    private String nombre;
    private String codigo;
    private String facultad;
    private Integer creditos;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFacultad() {
        return facultad;
    }
    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }
    
    public Integer getCreditos() {
        return creditos;
    }
    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public static CursoDomainEntity create(
        String id,
        String nombre,
        String codigo,
        String facultad,
        Integer creditos
    ){
        CursoDomainEntity cursoEntitiy = new CursoDomainEntity();

        cursoEntitiy.setId(id);
        cursoEntitiy.setNombre(nombre);
        cursoEntitiy.setCodigo(codigo);
        cursoEntitiy.setFacultad(facultad);
        cursoEntitiy.setCreditos(creditos);

        return cursoEntitiy;
    }
}
