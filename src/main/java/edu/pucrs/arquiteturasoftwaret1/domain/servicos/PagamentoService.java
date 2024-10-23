package edu.pucrs.arquiteturasoftwaret1.domain.servicos;

import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.entidades.AssinaturaEntity;
import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.entidades.PagamentoEntity;
import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.interfaceJPA.AssinaturaRepository_ItfRep;
import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.interfaceJPA.PagamentoRepository_ItfRep;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class PagamentoService {

    private final PagamentoRepository_ItfRep pagamentoRepositoryItfRep;
    private final AssinaturaRepository_ItfRep assinaturaRepositoryItfRep;

    public PagamentoEntity registrarPagamento(PagamentoEntity pagamento) throws BadRequestException {
        AssinaturaEntity assinatura = assinaturaRepositoryItfRep.findById(pagamento.getAssinatura().getCodigo())
                .orElseThrow(() -> new BadRequestException("Assinatura não encontrada"));

        if (pagamento.getValorPago().compareTo(assinatura.getCusto()) >= 0) {
            assinatura.setDataFim(assinatura.getDataFim().plusDays(30)); 
        }

        pagamento.setDataPagamento(LocalDate.now());
        assinaturaRepositoryItfRep.save(assinatura);

        return pagamentoRepositoryItfRep.save(pagamento);
    }
}