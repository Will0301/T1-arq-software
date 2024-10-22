package edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.repositoriosImpl;

import edu.pucrs.arquiteturasoftwaret1.domain.repository.IPagamentoRepository;
import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.interfaceJPA.PagamentoRepository_ItfRep;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class PagamentoRepImpl implements IPagamentoRepository {

    private PagamentoRepository_ItfRep pagamentoRepository;
}
