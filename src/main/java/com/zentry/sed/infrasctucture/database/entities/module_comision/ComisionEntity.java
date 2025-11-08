package com.zentry.sed.infrasctucture.database.entities.module_comision;

import java.util.UUID;

import com.zentry.sed.infrasctucture.database.entities.module_core.PeriodoEntity;
import com.zentry.sed.infrasctucture.database.entities.module_usuarios.UsuarioEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
    name = "comision"
)
@Getter
@Setter
public class ComisionEntity {
    
    @Id
    @GeneratedValue
    @Column(
        name = "id_comision", updatable = false, nullable = false,
        columnDefinition = "UUID DEFAULT gen_random_uuid()"
    )
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario" , nullable = false)
    private UsuarioEntity usuario;

    @Column(name = "facultad" , length = 100 , nullable = false)
    private String facultad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "periodo_id" , nullable = true)
    private PeriodoEntity periodo;

    @Column(name = "rol_miembro" , length = 50 , nullable = true)
    private String rolMiembro;
}
