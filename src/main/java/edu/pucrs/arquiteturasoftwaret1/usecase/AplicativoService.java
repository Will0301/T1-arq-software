package edu.pucrs.arquiteturasoftwaret1.usecase;

import edu.pucrs.arquiteturasoftwaret1.domain.entities.AplicativoEntity;
import edu.pucrs.arquiteturasoftwaret1.domain.repository.AplicativosRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AplicativoService {

    private AplicativosRepository aplicativosRepository;

    public void cadastrarApp(AplicativoEntity aplicativo) {
        aplicativosRepository.save(aplicativo);
    }

    public void editarApp(AplicativoEntity aplicativo) throws BadRequestException {
        final var oldApp = aplicativosRepository.findById(aplicativo.getCodigo()).orElse(null);
        if (oldApp != null) {
            aplicativosRepository.save(aplicativo);
        }
        else throw new BadRequestException("Aplicativo não existe");
    }

    public List<AplicativoEntity> listarApps() {
        final var appLists = aplicativosRepository.findAll();
        if (appLists.isEmpty()) return List.of(AplicativoEntity.builder().build());
        return appLists;
    }

    public List<AplicativoEntity> listarBy(String filter) {
        return List.of(AplicativoEntity.builder().build());
    }

    public AplicativoEntity atualizarCusto(Long idAplicativo, Double novoCusto) throws BadRequestException {
        AplicativoEntity app = aplicativosRepository.findById(idAplicativo)
            .orElseThrow(() -> new BadRequestException("Aplicativo não encontrado."));
        app.setCusto(novoCusto);
        return aplicativosRepository.save(app);
    }
}
