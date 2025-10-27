package com.zentry.sed.infrasctucture.database.entities.module_api;

import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
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
import jakarta.validation.constraints.NotNull;

@Entity
@Table(
    name = "preferencianotificacion"
)
public class PreferenciaNotificacionEntity {
    
    @Id
    @GeneratedValue
    @Column(name = "id_preferencianotificacion")
    private UUID id;

    @NotNull(message = "Debe especificar al menos una preferencia.")
    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private Map<String , Object> preferencias;

    // ----- Nota -----
    // Para almacenar este tipo de dato jsonb
    // Map<String, Object> datos = new HashMap<>();
    // datos.put("fecha", "2025-10-27");
    // datos.put("ubicacion", "Madrid");
    // datos.put("asistentes", List.of("Juan", "Ana", "Luis"));

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuario;
}
