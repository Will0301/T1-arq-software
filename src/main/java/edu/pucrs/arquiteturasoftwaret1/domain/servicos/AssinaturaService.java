package edu.pucrs.arquiteturasoftwaret1.domain.servicos;

import edu.pucrs.arquiteturasoftwaret1.aplicacao.dto.AssinaturaDTO;
import edu.pucrs.arquiteturasoftwaret1.domain.repository.IAssinaturaRepository;
import edu.pucrs.arquiteturasoftwaret1.domain.servicos.mapper.AssinaturaMapper;
import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.entidades.AssinaturaEntity;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssinaturaService {

    private final IAssinaturaRepository assinaturaRepository;

    public AssinaturaDTO criarAssinatura(AssinaturaDTO assinatura) {
        final var entity = AssinaturaMapper.mapToEntity(assinatura);
        return AssinaturaMapper.mapToDTO(assinaturaRepository.criarAssinatura(entity));
    }

    public List<AssinaturaDTO> listarAssinaturasPorTipo(String tipo) {
        return assinaturaRepository.listarAssinaturasPorTipo(tipo)
                .stream()
                .map(AssinaturaMapper::mapToDTO)
                .toList();
    }

    public List<AssinaturaDTO> listarAssinaturasPorCliente(Long codcli) {
        return assinaturaRepository.listarAssinaturasPorCliente(codcli)
                .stream()
                .map(AssinaturaMapper::mapToDTO)
                .toList();
    }

    public List<AssinaturaDTO> listarAssinaturasPorAplicativo(Long codapp) {
        return assinaturaRepository.listarAssinaturasPorAplicativo(codapp)
                .stream()
                .map(AssinaturaMapper::mapToDTO)
                .toList();
    }

    public boolean verificarAssinaturaValida(Long codass) throws BadRequestException {
        return assinaturaRepository.verificarAssinaturaValida(codass);
    }
}