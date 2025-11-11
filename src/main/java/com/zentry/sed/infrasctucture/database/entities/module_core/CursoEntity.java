package com.zentry.sed.infrasctucture.database.entities.module_core;

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
    name = "curso"
)
@Getter
@Setter
public class CursoEntity {
    
    @Id
    @GeneratedValue
    @Column(
        name = "id_curso" , updatable = false , nullable = false , 
        columnDefinition = "UUID DEFAULT gen_random_uuid()"
    )
    private UUID id;

    @Column(name = "nombre" , length = 100 , nullable = false)
    private String nombre;

    @Column(name = "codigo" , length = 20 , nullable = false , unique = true)
    private String codigo;

    @Column(name = "facultad" , length = 100 , nullable = true)
    private String facultad;

    @Column(name = "creditos" , nullable = true)
    private Integer creditos;
}
