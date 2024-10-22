package edu.pucrs.arquiteturasoftwaret1.domain.servicos;

import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.entidades.AplicativoEntity;
import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.entidades.AssinaturaEntity;
import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.entidades.ClienteEntity;
import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.interfaceJPA.AplicativosRepository_ItfRep;
import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.interfaceJPA.AssinaturaRepository_ItfRep;
import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.interfaceJPA.ClienteRepository_ItfRep;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AssinaturaService {

    private final AssinaturaRepository_ItfRep assinaturaRepositoryItfRep;
    private final AplicativosRepository_ItfRep aplicativosRepositoryItfRep;
    private final ClienteRepository_ItfRep clienteRepositoryItfRep;

    public AssinaturaEntity criarAssinatura(AssinaturaEntity assinatura) throws BadRequestException {
        AplicativoEntity app = aplicativosRepositoryItfRep.findById(assinatura.getAplicativo().getCodigo())
                .orElseThrow(() -> new BadRequestException("Aplicativo não encontrado"));
        ClienteEntity cliente = clienteRepositoryItfRep.findById(assinatura.getCliente().getCodigo())
                .orElseThrow(() -> new BadRequestException("Cliente não encontrado"));

        assinatura.setAplicativo(app);
        assinatura.setCliente(cliente);
        assinatura.setDataInicio(LocalDate.now());
        assinatura.setDataFim(LocalDate.now().plusDays(7)); 

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

    public boolean verificarAssinaturaValida(Long codass) {
        AssinaturaEntity assinatura = assinaturaRepositoryItfRep.findById(codass)
                .orElseThrow(() -> new BadRequestException("Assinatura não encontrada"));
        return LocalDate.now().isBefore(assinatura.getDataFim());
    }
}