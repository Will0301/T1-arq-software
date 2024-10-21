package edu.pucrs.arquiteturasoftwaret1.domain.repository;

import edu.pucrs.arquiteturasoftwaret1.domain.entities.AplicativoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AplicativosRepository extends JpaRepository<AplicativoEntity, Long> {
}
