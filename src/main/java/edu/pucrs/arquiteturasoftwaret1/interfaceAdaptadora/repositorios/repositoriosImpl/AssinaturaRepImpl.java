package edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.repositoriosImpl;

import edu.pucrs.arquiteturasoftwaret1.domain.repository.IAssinaturaRepository;
import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.entidades.AssinaturaEntity;
import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.interfaceJPA.AssinaturaRepository_ItfRep;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@Primary
@RequiredArgsConstructor
public class AssinaturaRepImpl implements IAssinaturaRepository {


    private final AssinaturaRepository_ItfRep assinaturaRepositoryItfRep;

    public AssinaturaEntity criarAssinatura(AssinaturaEntity assinatura) {
         return assinaturaRepositoryItfRep.save(assinatura);
    }

    public List<AssinaturaEntity> listarAssinaturasPorTipo(String tipo) {
        if ("ATIVAS".equalsIgnoreCase(tipo)) {
            return assinaturaRepositoryItfRep.findByDataFimAfter(LocalDate.now());
        } else if ("CANCELADAS".equalsIgnoreCase(tipo)) {
            return assinaturaRepositoryItfRep.findByDataFimBefore(LocalDate.now());
        } else {
            return assinaturaRepositoryItfRep.findAll();
        }
    }

    public List<AssinaturaEntity> listarAssinaturasPorCliente(Long codcli) {
        return assinaturaRepositoryItfRep.findByClienteCodigo(codcli);
    }

    public List<AssinaturaEntity> listarAssinaturasPorAplicativo(Long codapp) {
        return assinaturaRepositoryItfRep.findByAplicativoCodigo(codapp);
    }

    public boolean verificarAssinaturaValida(Long codass) throws BadRequestException {
        AssinaturaEntity assinatura = assinaturaRepositoryItfRep.findById(codass)
                .orElseThrow(() -> new BadRequestException("Assinatura não encontrada"));
        return LocalDate.now().isBefore(assinatura.getDataFim());
    }
}
