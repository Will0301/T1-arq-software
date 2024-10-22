package edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.repositoriosImpl;

import edu.pucrs.arquiteturasoftwaret1.domain.repository.IClienteRepository;
import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.interfaceJPA.ClienteRepository_ItfRep;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class ClienteRepImpl implements IClienteRepository {

    private ClienteRepository_ItfRep clienteRepository;
}
