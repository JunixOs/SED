package com.zentry.sed.core.entities.module_usuarios;

import java.time.LocalDateTime;

public class UsuarioDomainEntity {
    private String id;
    private String nombreCompleto;
    private String correo;
    private String passwordHash;
    private EstadoUsuarioDomainEntity estadoUsuarioDomainEntity;
    private LocalDateTime creadoEn;
    private LocalDateTime actualizadoEn;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public EstadoUsuarioDomainEntity getEstadoUsuarioDomainEntity() {
        return estadoUsuarioDomainEntity;
    }
    public void setEstadoUsuarioDomainEntity(EstadoUsuarioDomainEntity estadoUsuarioDomainEntity) {
        this.estadoUsuarioDomainEntity = estadoUsuarioDomainEntity;
    }

    public LocalDateTime getCreadoEn() {
        return creadoEn;
    }
    public void setCreadoEn(LocalDateTime creadoEn) {
        this.creadoEn = creadoEn;
    }

    public LocalDateTime getActualizadoEn() {
        return actualizadoEn;
    }
    public void setActualizadoEn(LocalDateTime actualizadoEn) {
        this.actualizadoEn = actualizadoEn;
    }

    public static UsuarioDomainEntity create(
        String nombreCompleto,
        String correo,
        String passwordHash,
        EstadoUsuarioDomainEntity estadoUsuarioDomainEntity
    ){
        LocalDateTime nowDateTime = LocalDateTime.now();

        UsuarioDomainEntity usuarioDomainEntity = new UsuarioDomainEntity();

        usuarioDomainEntity.setNombreCompleto(nombreCompleto);
        usuarioDomainEntity.setCorreo(correo);
        usuarioDomainEntity.setPasswordHash(passwordHash);
        usuarioDomainEntity.setEstadoUsuarioDomainEntity(estadoUsuarioDomainEntity);
        usuarioDomainEntity.setCreadoEn(nowDateTime);
        usuarioDomainEntity.setActualizadoEn(nowDateTime);

        return usuarioDomainEntity;
    }
}
