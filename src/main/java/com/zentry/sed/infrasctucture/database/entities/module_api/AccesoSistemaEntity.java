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
    name = "accesosistema"
)
@Setter
@Getter
public class AccesoSistemaEntity {
    
    @Id
    @GeneratedValue
    @Column(
        name = "id_accesosistema" , updatable = false , nullable = false , 
        columnDefinition = "UUID DEFAULT gen_random_uuid()"
    )
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id" , nullable = false)
    private UsuarioEntity usuario;

    @Column(name = "fecha_acceso" , columnDefinition = "TIMESTAMP" , nullable = false)
    private LocalDateTime fechaAcceso;

    @Column(name = "direccion_ip" , nullable = true , length = 45)
    private String direccionIp;

    @Lob
    @Column(name = "user_agent" , columnDefinition = "TEXT" , nullable = true)
    private String userAgent;
}
