package com.zentry.sed.infrasctucture.database.entities.module_roles;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
    name = "rol"
)
@Getter
@Setter
public class RolEntity implements Serializable {

    private static final long serialVersionUID = 1L;  // ← añade esto

    @Id
    @GeneratedValue
    @Column(
        name = "id_rol", updatable = false, nullable = false,
        columnDefinition = "UUID DEFAULT gen_random_uuid()"
    )
    private UUID id;

    @Column(name = "nombre", length = 50, nullable = false, unique = true)
    private String nombre;

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RolEntity that)) return false;
        return id != null && id.equals(that.id);
    }
    @Override public int hashCode() { return java.util.Objects.hashCode(id); }
}
