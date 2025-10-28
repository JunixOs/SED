package com.zentry.sed.infrasctucture.database.entities.module_usuarios;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import com.zentry.sed.infrasctucture.database.entities.module_roles.RolEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
    name = "usuario"
)
@Getter
@Setter
public class UsuarioEntity {
    
    /*
        Aqui solo anotaciones JPA
    */

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id_usuario")
    private UUID id;

    @Column(name = "nombre" , nullable = false , length = 100)
    private String nombre;

    @Column(name = "correo" , unique = true , nullable = false , length = 254)
    private String correo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rol_id")
    private RolEntity rol;

    @Column(name = "password_hash" , nullable = false , length = 128)
    private String passwordHash;

    @Column(name = "estado" , nullable = true , length = 20)
    private String estado;
    
    @Column(name = "creado_en" , columnDefinition = "TIMESTAMP")
    private LocalDateTime creadoEn;

    @Column(name = "actualizado_en" , columnDefinition = "TIMESTAMP")
    private LocalDateTime actualizadoEn;
}
