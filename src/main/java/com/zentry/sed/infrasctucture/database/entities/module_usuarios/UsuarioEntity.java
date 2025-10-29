package com.zentry.sed.infrasctucture.database.entities.module_usuarios;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.zentry.sed.infrasctucture.database.entities.module_roles.RolEntity;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class UsuarioEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_usuario", updatable = false, nullable = false,
            columnDefinition = "UUID DEFAULT gen_random_uuid()") // Esto permite que la propia base de datos PostgreSQL se encargue de generar automaticamente el UUID
    private UUID id;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(unique = true, length = 254, nullable = false)
    private String correo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rol_id", nullable = false)
    private RolEntity rol;

    @Column(name = "password_hash", length = 128, nullable = false)
    private String passwordHash;

    @Column(length = 20)
    private String estado;

    @Column(name = "creado_en", columnDefinition = "TIMESTAMP")
    private LocalDateTime creadoEn;

    @Column(name = "actualizado_en", columnDefinition = "TIMESTAMP")
    private LocalDateTime actualizadoEn;

    /* ===== Constructores ===== */

    // JPA necesita un constructor público/protegido sin argumentos
    public UsuarioEntity() {}

    // Constructor completo (opcional)
    public UsuarioEntity(UUID id, String nombre, String correo, RolEntity rol, String passwordHash,
                         String estado, LocalDateTime creadoEn, LocalDateTime actualizadoEn) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.rol = rol;
        this.passwordHash = passwordHash;
        this.estado = estado;
        this.creadoEn = creadoEn;
        this.actualizadoEn = actualizadoEn;
    }

    /* ===== Getters ===== */

    public UUID getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public RolEntity getRol() { return rol; }
    public String getPasswordHash() { return passwordHash; }
    public String getEstado() { return estado; }
    public LocalDateTime getCreadoEn() { return creadoEn; }
    public LocalDateTime getActualizadoEn() { return actualizadoEn; }

    /* ===== Setters ===== */

    public void setId(UUID id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCorreo(String correo) { this.correo = correo; }
    public void setRol(RolEntity rol) { this.rol = rol; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
    public void setEstado(String estado) { this.estado = estado; }
    public void setCreadoEn(LocalDateTime creadoEn) { this.creadoEn = creadoEn; }
    public void setActualizadoEn(LocalDateTime actualizadoEn) { this.actualizadoEn = actualizadoEn; }

    /* ===== equals/hashCode por ID ===== */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsuarioEntity that)) return false;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() { return Objects.hashCode(id); }

    @Override
    public String toString() {
        return "UsuarioEntity{id=" + id + ", correo='" + correo + "', nombre='" + nombre + "'}";
    }
}
