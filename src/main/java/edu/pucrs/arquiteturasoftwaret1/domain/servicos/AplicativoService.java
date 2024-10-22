package edu.pucrs.arquiteturasoftwaret1.domain.servicos;

import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.entidades.AplicativoEntity;
import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.interfaceJPA.AplicativosRepository_ItfRep;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AplicativoService {

    private AplicativosRepository_ItfRep aplicativosRepositoryItfRep;

    public void cadastrarApp(AplicativoEntity aplicativo) {
        aplicativosRepositoryItfRep.save(aplicativo);
    }

    public void editarApp(AplicativoEntity aplicativo) throws BadRequestException {
        final var oldApp = aplicativosRepositoryItfRep.findById(aplicativo.getCodigo()).orElse(null);
        if (oldApp != null) {
            aplicativosRepositoryItfRep.save(aplicativo);
        }
        else throw new BadRequestException("Aplicativo não existe");
    }

    public List<AplicativoEntity> listarApps() {
        final var appLists = aplicativosRepositoryItfRep.findAll();
        if (appLists.isEmpty()) return List.of(AplicativoEntity.builder().build());
        return appLists;
    }

    public List<AplicativoEntity> listarBy(String filter) {
        return List.of(AplicativoEntity.builder().build());
    }

    public AplicativoEntity atualizarCusto(Long idAplicativo, Double novoCusto) throws BadRequestException {
        AplicativoEntity app = aplicativosRepositoryItfRep.findById(idAplicativo)
            .orElseThrow(() -> new BadRequestException("Aplicativo não encontrado."));
        app.setCusto(novoCusto);
        return aplicativosRepositoryItfRep.save(app);
    }
}
