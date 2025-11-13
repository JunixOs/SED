package com.zentry.sed.infrasctucture.database.entities.module_api;

import java.util.Map;
import java.util.UUID;

import org.hibernate.annotations.Type;
import com.vladmihalcea.hibernate.type.json.JsonType;
import com.zentry.sed.infrasctucture.database.entities.module_usuarios.UsuarioEntity;

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
    name = "preferencia_notificacion"
)
@Getter
@Setter
public class PreferenciaNotificacionEntity {
    
    @Id
    @GeneratedValue
    @Column(
        name = "id_preferencia_notificacion" , updatable = false , nullable = false , 
        columnDefinition = "UUID DEFAULT gen_random_uuid()"
    )
    private UUID id;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb" , nullable = false)
    private Map<String , Object> preferencias;

    // ----- Nota -----
    // Para almacenar este tipo de dato jsonb
    // Map<String, Object> datos = new HashMap<>();
    // datos.put("fecha", "2025-10-27");
    // datos.put("ubicacion", "Madrid");
    // datos.put("asistentes", List.of("Juan", "Ana", "Luis"));

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id" , nullable = false)
    private UsuarioEntity usuario;
}
