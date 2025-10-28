package com.zentry.sed.infrasctucture.database.entities.module_comision;

import java.util.UUID;

import com.zentry.sed.infrasctucture.database.entities.module_core.PeriodoEntity;
import com.zentry.sed.infrasctucture.database.entities.module_usuarios.UsuarioEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;

    @NotNull(message = "Debe especificar una facultad.")
    @Size(max = 100 , message = "La facultad debe tener menos de 100 caracteres.")
    private String facultad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "periodo_id")
    private PeriodoEntity periodo;

    @Size(max = 50 , message = "El rol del miembro debe tener menos de 50 caracteres.")
    @Column(name = "rol_miembro")
    private String rolMiembro;
}
