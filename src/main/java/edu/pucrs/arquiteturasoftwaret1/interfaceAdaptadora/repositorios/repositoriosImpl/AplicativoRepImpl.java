package edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.repositoriosImpl;

import edu.pucrs.arquiteturasoftwaret1.domain.repository.IAplicativoRepository;
import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.interfaceJPA.AplicativosRepository_ItfRep;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class AplicativoRepImpl implements IAplicativoRepository {

    private AplicativosRepository_ItfRep aplicativosRepository;
}
