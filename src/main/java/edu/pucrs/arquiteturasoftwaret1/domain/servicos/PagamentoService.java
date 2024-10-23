package edu.pucrs.arquiteturasoftwaret1.domain.servicos;

import edu.pucrs.arquiteturasoftwaret1.domain.repository.IPagamentoRepository;
import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.entidades.PagamentoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PagamentoService {

    private final IPagamentoRepository pagamentoRepository;

    public PagamentoEntity registrarPagamento(PagamentoEntity pagamento){
        return pagamentoRepository.registrarPagamento(pagamento);
    }
}