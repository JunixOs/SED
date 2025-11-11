package com.zentry.sed.infrasctucture.database.mappers.module_core;

import com.zentry.sed.core.entities.module_core.ModalidadSeccionDomainEntity;
import com.zentry.sed.infrasctucture.database.entities.module_core.ModalidadSeccionEntity;

public class ModalidadSeccionMapper {
    public static ModalidadSeccionEntity toEntity(ModalidadSeccionDomainEntity modalidadSeccionDomainEntity){
        ModalidadSeccionEntity modalidadSeccionEntity = new ModalidadSeccionEntity();

        modalidadSeccionEntity.setCodigo(modalidadSeccionDomainEntity.getCodigo());
        modalidadSeccionEntity.setEtiqueta(modalidadSeccionDomainEntity.getEtiqueta());

        return modalidadSeccionEntity;
    }

    public static ModalidadSeccionDomainEntity toDomain(ModalidadSeccionEntity modalidadSeccionEntity){
        ModalidadSeccionDomainEntity modalidadSeccionDomainEntity = new ModalidadSeccionDomainEntity();

        modalidadSeccionDomainEntity.setCodigo(modalidadSeccionEntity.getCodigo());
        modalidadSeccionDomainEntity.setEtiqueta(modalidadSeccionEntity.getEtiqueta());

        return modalidadSeccionDomainEntity;
    }
}
