package edu.pucrs.arquiteturasoftwaret1.domain.servicos;

import edu.pucrs.arquiteturasoftwaret1.domain.repository.IAplicativoRepository;
import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.entidades.AplicativoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AplicativoService {

    private IAplicativoRepository aplicativosRepository;

    public void cadastrarApp(AplicativoEntity aplicativo) {
        aplicativosRepository.cadastrarApp(aplicativo);
    }

    public List<AplicativoEntity> listarApps() {
        return aplicativosRepository.listarApps();
    }

    public List<AplicativoEntity> listarBy(String filter) {
        return aplicativosRepository.listarBy(filter);
    }

    public AplicativoEntity atualizarCusto(Long idAplicativo, Double novoCusto) {
        return aplicativosRepository.atualizarCusto(idAplicativo, novoCusto);
    }
}
