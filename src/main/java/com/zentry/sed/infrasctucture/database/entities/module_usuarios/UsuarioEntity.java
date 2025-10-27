package com.zentry.sed.infrasctucture.database.entities.module_usuarios;

import java.time.LocalDateTime;
import java.util.UUID;

import com.zentry.sed.infrasctucture.database.entities.module_roles.RolEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
    name = "usuario"
)
@Getter
@Setter
@AllArgsConstructor
public class UsuarioEntity {
    
    @Id
    @GeneratedValue
    private UUID id;

    @NotNull(message = "Debe proporcionar un nombre.")
    @Size(max = 100 , message = "El nombre debe tener menos de 100 caracteres.")
    private String nombre;

    @NotNull(message = "Debe proporcionar un correo.")
    @Size(max = 254 , message = "El correo debe tener menos de 254 caracteres.")
    private String correo;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rol_id")
    private RolEntity rol;

    @NotNull(message = "Debe proporcionar un hash.")
    @Size(max = 128 , message = "El hash debe tener menos de 128 caracteres.")
    @Column(name = "password_hash")
    private String passwordHash;

    @Size(max = 20 , message = "El estado debe tener menos de 20 caracteres.")
    private String estado;
    
    @Column(name = "creado_en" , columnDefinition = "TIMESTAMP")
    private LocalDateTime creadoEn;

    @Column(name = "actualizado_en" , columnDefinition = "TIMESTAMP")
    private LocalDateTime actualizadoEn;
}
