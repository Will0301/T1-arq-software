package edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.interfaceJPA;

import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.entidades.PagamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository_ItfRep extends JpaRepository<PagamentoEntity, Long> {
}