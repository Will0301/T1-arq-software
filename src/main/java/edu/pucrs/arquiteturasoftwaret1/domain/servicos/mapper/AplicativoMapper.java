package edu.pucrs.arquiteturasoftwaret1.domain.servicos.mapper;

import edu.pucrs.arquiteturasoftwaret1.aplicacao.dto.AplicativoDTO;
import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.entidades.AplicativoEntity;

public class AplicativoMapper {

    public static AplicativoEntity mapToEntity(AplicativoDTO aplicativoDTO) {
        return AplicativoEntity.builder()
                .custo(aplicativoDTO.getCusto())
                .nome(aplicativoDTO.getNome())
                .codigo(aplicativoDTO.getCodigo())
                .build();
    }

    public static AplicativoDTO mapToDTO(AplicativoEntity aplicativoEntity) {
        return AplicativoDTO.builder()
                .custo(aplicativoEntity.getCusto())
                .nome(aplicativoEntity.getNome())
                .codigo(aplicativoEntity.getCodigo())
                .build();
    }
}
