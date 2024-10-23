package edu.pucrs.arquiteturasoftwaret1.aplicacao.usecase;

import edu.pucrs.arquiteturasoftwaret1.aplicacao.dto.AssinaturaDTO;
import edu.pucrs.arquiteturasoftwaret1.aplicacao.dto.PagamentoDTO;
import edu.pucrs.arquiteturasoftwaret1.domain.servicos.AplicativoService;
import edu.pucrs.arquiteturasoftwaret1.domain.servicos.AssinaturaService;
import edu.pucrs.arquiteturasoftwaret1.domain.servicos.ClienteService;
import edu.pucrs.arquiteturasoftwaret1.domain.servicos.PagamentoService;
import org.springframework.stereotype.Component;

@Component
public class EfetuarAssinatura {

    ClienteService clienteService;
    AssinaturaService assinaturaService;
    PagamentoService pagamentoService;
    AplicativoService aplicativoService;

    public AssinaturaService getAssinaturaService(String clientId, String codApp, PagamentoDTO pagamento) {
        final var cliente = clienteService.listarBy(clientId);
        final var app = aplicativoService.listarBy(codApp);
        AssinaturaDTO assinaturaDTO = new AssinaturaDTO();

    }
}
