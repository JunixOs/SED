package com.zentry.sed.infrasctucture.database.entities.module_configuracion;

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
    name = "parametro"
)
@Getter
@Setter
public class ParametroEntity {
    
    @Id
    @GeneratedValue
    @Column(
        name = "id_parametro" , updatable = false , nullable = false , 
        columnDefinition = "UUID DEFAULT gen_random_uuid()"
    )
    private UUID id;

    @Column(name = "nombre" , length = 100 , nullable = false)
    private String nombre;
    
    @Column(name = "valor" , length = 200 , nullable = false)
    private String valor;
}
