package com.zentry.sed.infrasctucture.database.entities.module_api;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

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
    @UuidGenerator
    @Column(name = "id_accesosistema")
    private UUID id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuario;

    @NotNull(message = "Debe proporcionar una fecha de acceso.")
    @Column(name = "fecha_acceso" , columnDefinition = "TIMESTAMP")
    private LocalDateTime fechaAcceso;

    @Size(max = 45 , message = "La direccion IP debe tener menos de 45 caracteres.")
    @Column(name = "direccion_ip")
    private String direccionIp;

    @Lob
    @Column(name = "user_agent" , columnDefinition = "TEXT")
    private String userAgent;
}
