package edu.pucrs.arquiteturasoftwaret1.domain.servicos.mapper;

import edu.pucrs.arquiteturasoftwaret1.aplicacao.dto.ClienteDTO;
import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.entidades.ClienteEntity;

public class ClientMapper {

    public static ClienteEntity mapToEntity(ClienteDTO clienteDTO) {
        return ClienteEntity.builder()
                .email(clienteDTO.getEmail())
                .nome(clienteDTO.getNome())
                .codigo(clienteDTO.getCodigo())
                .build();
    }

    public static ClienteDTO mapToDTO(ClienteEntity clienteEntity) {
        return ClienteDTO.builder()
                .email(clienteEntity.getEmail())
                .nome(clienteEntity.getNome())
                .codigo(clienteEntity.getCodigo())
                .build();
    }
}
