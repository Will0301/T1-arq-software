package edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.interfaceJPA;

import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.entidades.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository_ItfRep extends JpaRepository<ClienteEntity, Long> {
}
