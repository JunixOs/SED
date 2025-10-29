package com.zentry.sed.infrasctucture.database.entities.module_usuarios;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import com.zentry.sed.infrasctucture.database.entities.module_roles.RolEntity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuario")
public class UsuarioEntity implements Serializable {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id_usuario", updatable = false, nullable = false)
    private UUID id;

    @NotNull(message = "Debe proporcionar un nombre.")
    @Size(max = 100, message = "El nombre debe tener menos de 100 caracteres.")
    @Column(length = 100, nullable = false)
    private String nombre;

    @NotNull(message = "Debe proporcionar un correo.")
    @Size(max = 254, message = "El correo debe tener menos de 254 caracteres.")
    @Column(unique = true, length = 254, nullable = false)
    private String correo;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rol_id", nullable = false)
    private RolEntity rol;

    @NotNull(message = "Debe proporcionar un hash.")
    @Size(max = 128, message = "El hash debe tener menos de 128 caracteres.")
    @Column(name = "password_hash", length = 128, nullable = false)
    private String passwordHash;

    @Size(max = 20, message = "El estado debe tener menos de 20 caracteres.")
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
