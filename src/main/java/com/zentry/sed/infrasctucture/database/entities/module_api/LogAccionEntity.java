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
    name = "logaccion"
)
@Getter
@Setter
public class LogAccionEntity {
    
    @Id
    @GeneratedValue
    @Column(
        name = "id_logaccion" , updatable = false , nullable = false , 
        columnDefinition = "UUID DEFAULT gen_random_uuid()"
    )
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id" , nullable = true)
    private UsuarioEntity usuario;

    @Column(name = "accion" , nullable = false , length = 100)
    private String accion;

    @Column(name = "entidad" , nullable = true , length = 50)
    private String entidad;

    @Column(name = "entidad_id" , nullable = true)
    private UUID entidadId;

    @Lob
    @Column(name = "detalle" , columnDefinition = "TEXT" , nullable = true)
    private String detalle;

    @Column(name = "fecha" , columnDefinition = "TIMESTAMP" , nullable = false)
    private LocalDateTime fecha;
}
