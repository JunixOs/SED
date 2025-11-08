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
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
    name = "notificacion"
)
@Getter
@Setter
public class NotificacionEntity {
    
    @Id
    @GeneratedValue
    @Column(
        name = "id_notificacion" , updatable = false , nullable = false , 
        columnDefinition = "UUID DEFAULT gen_random_uuid()"
    )
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario" , nullable = false)
    private UsuarioEntity usuario;

    @Column(name = "tipo" , length = 50 , nullable = true)
    private String tipo;

    @Lob
    @Column(name = "mensaje" , columnDefinition = "TEXT" , nullable = false)
    private String mensaje;

    @Column(name = "tipo_entidad" , length = 50 , nullable = true)
    private String tipoEntidad;

    @Column(name = "id_entidad" , nullable = true)
    private UUID idEntidad;
    
    @Column(name = "leido" , nullable = false)
    private Boolean leido = false;

    @Column(name = "fecha" , columnDefinition = "TIMESTAMP" , nullable = false)
    private LocalDateTime fecha;
}
