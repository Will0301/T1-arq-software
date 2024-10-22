package edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.interfaceJPA;

import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.entidades.AplicativoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AplicativosRepository_ItfRep extends JpaRepository<AplicativoEntity, Long> {
}
