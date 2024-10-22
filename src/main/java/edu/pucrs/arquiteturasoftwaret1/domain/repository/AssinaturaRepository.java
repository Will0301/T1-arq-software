package edu.pucrs.arquiteturasoftwaret1.domain.repository;

import edu.pucrs.arquiteturasoftwaret1.domain.entities.AssinaturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AssinaturaRepository extends JpaRepository<AssinaturaEntity, Long> {
    List<AssinaturaEntity> findByClienteCodigo(Long clienteId);
    List<AssinaturaEntity> findByAplicativoCodigo(Long aplicativoId);
    List<AssinaturaEntity> findByDataFimAfter(LocalDate data);
    List<AssinaturaEntity> findByDataFimBefore(LocalDate data);
}