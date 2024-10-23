package edu.pucrs.arquiteturasoftwaret1.domain.servicos;

import edu.pucrs.arquiteturasoftwaret1.domain.repository.IAssinaturaRepository;
import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.entidades.AssinaturaEntity;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssinaturaService {

    private final IAssinaturaRepository assinaturaRepository;

    public AssinaturaEntity criarAssinatura(AssinaturaEntity assinatura) {
        return assinaturaRepository.criarAssinatura(assinatura);
    }

    public List<AssinaturaEntity> listarAssinaturasPorTipo(String tipo) {
        return assinaturaRepository.listarAssinaturasPorTipo(tipo);
    }

    public List<AssinaturaEntity> listarAssinaturasPorCliente(Long codcli) {
        return assinaturaRepository.listarAssinaturasPorCliente(codcli);
    }

    public List<AssinaturaEntity> listarAssinaturasPorAplicativo(Long codapp) {
        return assinaturaRepository.listarAssinaturasPorAplicativo(codapp);
    }

    public boolean verificarAssinaturaValida(Long codass) throws BadRequestException {
        return assinaturaRepository.verificarAssinaturaValida(codass);
    }
}