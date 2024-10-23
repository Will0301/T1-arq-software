package edu.pucrs.arquiteturasoftwaret1.domain.repository;

import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.entidades.PagamentoEntity;

public interface IPagamentoRepository {
    PagamentoEntity registrarPagamento(PagamentoEntity pagamento);
}
