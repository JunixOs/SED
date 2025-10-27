package com.zentry.sed.infrasctucture.database.entities.module_api;

import java.time.LocalDateTime;
import java.util.UUID;

import com.zentry.sed.infrasctucture.database.entities.module_usuarios.UsuarioEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
    name = "logaccion"
)
@Getter
@Setter
@AllArgsConstructor
public class LogAccionEntity {
    
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario-id")
    private UsuarioEntity usuario;

    @NotNull(message = "Debe especificar una accion.")
    @Size(max = 100 , message = "La accion debe tener menos de 100 caracteres.")
    private String accion;

    @Size(max = 50 , message = "La entidad debe tener menos de 50 caracteres.")
    private String entidad;

    @Column(name = "entidad_id")
    private UUID entidadId;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String detalle;

    @NotNull(message = "Debe especificar una fecha.")
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime fecha;
}
