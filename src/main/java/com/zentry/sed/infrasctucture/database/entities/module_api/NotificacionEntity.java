package com.zentry.sed.infrasctucture.database.entities.module_api;

import java.time.LocalDateTime;
import java.util.UUID;

import com.zentry.sed.infrasctucture.database.entities.module_usuarios.UsuarioEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
    name = "notificacion"
)
@Getter
@Setter
@AllArgsConstructor
public class NotificacionEntity {
    
    @Id
    @GeneratedValue
    @Column(name = "id_notificacion")
    private UUID id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;

    @Size(max = 50 , message = "El tipo debe ser menor a 50 caracteres.")
    private String tipo;

    @NotNull
    @Lob
    @Column(columnDefinition = "TEXT")
    private String mensaje;

    @Size(max = 50 , message = "el tipo de entidad debe ser menor a 50 caracteres.")
    @Column(name = "entity_tipo")
    private String entityTipo;

    @Column(name = "entity_id")
    private UUID entityId;
    
    @NotNull
    private Boolean leido = false;

    @NotNull(message = "Debe proporcionar una fecha.")
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime fecha;
}
