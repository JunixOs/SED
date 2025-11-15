package com.zentry.sed.infrasctucture.database.entities.module_evaluacion;

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
    name = "canal"
)
@Getter
@Setter
public class CanalEntity {
    
    @Id
    @GeneratedValue
    @Column(
        name = "id_canal", updatable = false, nullable = false,
        columnDefinition = "UUID DEFAULT gen_random_uuid()"
    )
    private UUID id;

    @Column(name = "codigo" , length = 20 , nullable = false , unique = true)
    private String codigo;

    @Column(name = "etiqueta" , length = 50 , nullable = true)
    private String etiqueta;
}
