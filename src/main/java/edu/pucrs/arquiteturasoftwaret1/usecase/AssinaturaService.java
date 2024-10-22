package edu.pucrs.arquiteturasoftwaret1.usecase;

import edu.pucrs.arquiteturasoftwaret1.domain.entities.AplicativoEntity;
import edu.pucrs.arquiteturasoftwaret1.domain.entities.AssinaturaEntity;
import edu.pucrs.arquiteturasoftwaret1.domain.entities.ClienteEntity;
import edu.pucrs.arquiteturasoftwaret1.domain.repository.AplicativosRepository;
import edu.pucrs.arquiteturasoftwaret1.domain.repository.AssinaturaRepository;
import edu.pucrs.arquiteturasoftwaret1.domain.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AssinaturaService {

    private final AssinaturaRepository assinaturaRepository;
    private final AplicativosRepository aplicativosRepository;
    private final ClienteRepository clienteRepository;

    public AssinaturaEntity criarAssinatura(AssinaturaEntity assinatura) throws BadRequestException {
        AplicativoEntity app = aplicativosRepository.findById(assinatura.getAplicativo().getCodigo())
                .orElseThrow(() -> new BadRequestException("Aplicativo não encontrado"));
        ClienteEntity cliente = clienteRepository.findById(assinatura.getCliente().getCodigo())
                .orElseThrow(() -> new BadRequestException("Cliente não encontrado"));

        assinatura.setAplicativo(app);
        assinatura.setCliente(cliente);
        assinatura.setDataInicio(LocalDate.now());
        assinatura.setDataFim(LocalDate.now().plusDays(7)); 

        return assinaturaRepository.save(assinatura);
    }

    public List<AssinaturaEntity> listarAssinaturasPorTipo(String tipo) {
        if ("ATIVAS".equalsIgnoreCase(tipo)) {
            return assinaturaRepository.findByDataFimAfter(LocalDate.now());
        } else if ("CANCELADAS".equalsIgnoreCase(tipo)) {
            return assinaturaRepository.findByDataFimBefore(LocalDate.now());
        } else {
            return assinaturaRepository.findAll();
        }
    }

    public List<AssinaturaEntity> listarAssinaturasPorCliente(Long codcli) {
        return assinaturaRepository.findByClienteCodigo(codcli);
    }

    public List<AssinaturaEntity> listarAssinaturasPorAplicativo(Long codapp) {
        return assinaturaRepository.findByAplicativoCodigo(codapp);
    }

    public boolean verificarAssinaturaValida(Long codass) {
        AssinaturaEntity assinatura = assinaturaRepository.findById(codass)
                .orElseThrow(() -> new BadRequestException("Assinatura não encontrada"));
        return LocalDate.now().isBefore(assinatura.getDataFim());
    }
}