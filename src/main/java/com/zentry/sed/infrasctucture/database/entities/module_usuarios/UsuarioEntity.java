package com.zentry.sed.infrasctucture.database.entities.module_usuarios;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
    name = "usuario"
)
@Getter
@Setter
public class UsuarioEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_usuario", updatable = false, nullable = false,
            columnDefinition = "UUID DEFAULT gen_random_uuid()") // Esto permite que la propia base de datos PostgreSQL se encargue de generar automaticamente el UUID
    private UUID id;

    @Column(name = "nombre_completo" , length = 100, nullable = false)
    private String nombreCompleto;

    @Column(name = "correo" , unique = true, length = 254, nullable = false)
    private String correo;

    @Column(name = "password_hash", length = 128, nullable = false)
    private String passwordHash;

    @Column(name = "estado_usuario_id" , length = 20)
    private EstadoUsuarioEntity estadoUsuarioEntity;

    @Column(name = "creado_en", columnDefinition = "TIMESTAMP")
    private LocalDateTime creadoEn;

    @Column(name = "actualizado_en", columnDefinition = "TIMESTAMP")
    private LocalDateTime actualizadoEn;

    /* ===== equals/hashCode por ID ===== */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsuarioEntity that)) return false;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() { return Objects.hashCode(id); }
}
