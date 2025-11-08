package com.zentry.sed.infrasctucture.database.entities.module_usuarios;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
    name = "estado_usuario"
)
@Getter
@Setter
public class EstadoUsuarioEntity {
    
    @Id
    @GeneratedValue
    @Column(
        name = "id_estado_usuario", updatable = false, nullable = false,
        columnDefinition = "UUID DEFAULT gen_random_uuid()")
    private UUID id;

    @Column(name = "codigo" , nullable = false , length = 30)
    private String codigo;

    @Column(name = "etiqueta" , nullable = true , length = 50)
    private String etiqueta;
}
