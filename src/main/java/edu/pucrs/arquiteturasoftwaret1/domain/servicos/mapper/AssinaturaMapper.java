package edu.pucrs.arquiteturasoftwaret1.domain.servicos.mapper;

import edu.pucrs.arquiteturasoftwaret1.aplicacao.dto.AssinaturaDTO;
import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.entidades.AssinaturaEntity;

public class AssinaturaMapper {

    public static AssinaturaEntity mapToEntity(AssinaturaDTO assinaturaDTO) {
        return AssinaturaEntity.builder()
                .codigo(assinaturaDTO.getCodigo())
                .dataInicio(assinaturaDTO.getDataInicio())
                .dataFim(assinaturaDTO.getDataFim())
                .build();
    }

    public static AssinaturaDTO mapToDTO(AssinaturaEntity assinaturaEntity) {
        return AssinaturaDTO.builder()
                .codigo(assinaturaEntity.getCodigo())
                .dataInicio(assinaturaEntity.getDataInicio())
                .dataFim(assinaturaEntity.getDataFim())
                .build();
    }
}
