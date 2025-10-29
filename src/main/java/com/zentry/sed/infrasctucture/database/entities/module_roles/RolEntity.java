package com.zentry.sed.infrasctucture.database.entities.module_roles;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.*;

@Entity
@Table(name = "rol")
public class RolEntity implements Serializable {

    private static final long serialVersionUID = 1L;  // ← añade esto

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id_rol", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "nombre", length = 50, nullable = false, unique = true)
    private String nombre;

    @Column(name = "permisos", columnDefinition = "TEXT")
    private String permisos;

    public RolEntity() {}
    public RolEntity(UUID id, String nombre, String permisos) {
        this.id = id; this.nombre = nombre; this.permisos = permisos;
    }

    public UUID getId() { return id; }
    public String getNombre() { return nombre; }
    public String getPermisos() { return permisos; }
    public void setId(UUID id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPermisos(String permisos) { this.permisos = permisos; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RolEntity that)) return false;
        return id != null && id.equals(that.id);
    }
    @Override public int hashCode() { return java.util.Objects.hashCode(id); }
    @Override public String toString() { return "RolEntity{id=" + id + ", nombre='" + nombre + "'}"; }
}
