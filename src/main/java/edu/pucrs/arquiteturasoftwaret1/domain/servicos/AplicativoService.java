package edu.pucrs.arquiteturasoftwaret1.domain.servicos;

import edu.pucrs.arquiteturasoftwaret1.aplicacao.dto.AplicativoDTO;
import edu.pucrs.arquiteturasoftwaret1.domain.repository.IAplicativoRepository;
import edu.pucrs.arquiteturasoftwaret1.domain.servicos.mapper.AplicativoMapper;
import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.entidades.AplicativoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AplicativoService {

    private IAplicativoRepository aplicativosRepository;

    public void cadastrarApp(AplicativoDTO aplicativo) {
        final var entity = AplicativoMapper.mapToEntity(aplicativo);
        aplicativosRepository.cadastrarApp(entity);
    }

    public List<AplicativoDTO> listarApps() {
        return aplicativosRepository.listarApps()
                .stream()
                .map(AplicativoMapper::mapToDTO)
                .toList();
    }

    public List<AplicativoDTO> listarBy(String filter) {
        return aplicativosRepository.listarBy(filter)
                .stream()
                .map(AplicativoMapper::mapToDTO)
                .toList();
    }

    public AplicativoDTO atualizarCusto(Long idAplicativo, Double novoCusto) {
        return AplicativoMapper.mapToDTO(aplicativosRepository.atualizarCusto(idAplicativo, novoCusto));
    }
}
