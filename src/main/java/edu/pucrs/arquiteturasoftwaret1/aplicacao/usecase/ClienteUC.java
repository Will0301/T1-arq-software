package edu.pucrs.arquiteturasoftwaret1.aplicacao.usecase;

import edu.pucrs.arquiteturasoftwaret1.aplicacao.dto.AssinaturaDTO;
import edu.pucrs.arquiteturasoftwaret1.domain.servicos.AssinaturaService;
import edu.pucrs.arquiteturasoftwaret1.domain.servicos.ClienteService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ClienteUC {

    ClienteService clienteService;
    AssinaturaService assinaturaService;

    public List<AssinaturaDTO> listarAssinaturas(long codCliente) throws BadRequestException {
        final var cliente = clienteService.listarClientes().stream()
                .filter(clienteEntity -> clienteEntity.getCodigo() == codCliente)
                .findFirst()
                .orElseThrow(() -> new BadRequestException("Cliente não existe"));

        final var assinaturas = assinaturaService.listarAssinaturas PorCliente(cliente.getCodigo());
    }
}
