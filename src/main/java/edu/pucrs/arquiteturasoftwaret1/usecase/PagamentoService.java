package edu.pucrs.arquiteturasoftwaret1.usecase;

import edu.pucrs.arquiteturasoftwaret1.domain.entities.AssinaturaEntity;
import edu.pucrs.arquiteturasoftwaret1.domain.entities.PagamentoEntity;
import edu.pucrs.arquiteturasoftwaret1.domain.repository.AssinaturaRepository;
import edu.pucrs.arquiteturasoftwaret1.domain.repository.PagamentoRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;
    private final AssinaturaRepository assinaturaRepository;

    public PagamentoEntity registrarPagamento(PagamentoEntity pagamento) throws BadRequestException {
        AssinaturaEntity assinatura = assinaturaRepository.findById(pagamento.getAssinatura().getCodigo())
                .orElseThrow(() -> new BadRequestException("Assinatura não encontrada"));

        if (pagamento.getValorPago().compareTo(assinatura.getAplicativo().getCusto()) >= 0) {
            assinatura.setDataFim(assinatura.getDataFim().plusDays(30)); 
        }

        pagamento.setDataPagamento(LocalDate.now());
        assinaturaRepository.save(assinatura);

        return pagamentoRepository.save(pagamento);
    }
}