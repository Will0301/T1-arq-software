package edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.repositoriosImpl;

import edu.pucrs.arquiteturasoftwaret1.domain.repository.IAssinaturaRepository;
import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.interfaceJPA.AssinaturaRepository_ItfRep;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class AssinaturaRepImpl implements IAssinaturaRepository {

    private AssinaturaRepository_ItfRep assinaturaRepository;
}
