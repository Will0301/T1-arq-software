package edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.repositoriosImpl;

import edu.pucrs.arquiteturasoftwaret1.domain.repository.IPagamentoRepository;
import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.entidades.PagamentoEntity;
import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.interfaceJPA.PagamentoRepository_ItfRep;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
@RequiredArgsConstructor
public class PagamentoRepImpl implements IPagamentoRepository {

    private final PagamentoRepository_ItfRep pagamentoRepositoryItfRep;

    public PagamentoEntity registrarPagamento(PagamentoEntity pagamento) {
        return pagamentoRepositoryItfRep.save(pagamento);
    }
}
