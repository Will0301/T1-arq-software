package edu.pucrs.arquiteturasoftwaret1.domain.servicos.mapper;

import edu.pucrs.arquiteturasoftwaret1.aplicacao.dto.PagamentoDTO;
import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.entidades.PagamentoEntity;

public class PagamentoMapper {

    public static PagamentoEntity mapToEntity(PagamentoDTO pagamentoDTO) {
        return PagamentoEntity.builder()
                .id(pagamentoDTO.getId())
                .codAssinatura(pagamentoDTO.getCodAssinatura())
                .cupom(pagamentoDTO.getCupom())
                .dataPagamento(pagamentoDTO.getDataPagamento())
                .valorPago(pagamentoDTO.getValorPago())
                .build();
    }

    public static PagamentoDTO mapToDTO(PagamentoEntity pagamentoEntity) {
        return PagamentoDTO.builder()
                .id(pagamentoEntity.getId())
                .codAssinatura(pagamentoEntity.getCodAssinatura())
                .cupom(pagamentoEntity.getCupom())
                .dataPagamento(pagamentoEntity.getDataPagamento())
                .valorPago(pagamentoEntity.getValorPago())
                .build();
    }
}
