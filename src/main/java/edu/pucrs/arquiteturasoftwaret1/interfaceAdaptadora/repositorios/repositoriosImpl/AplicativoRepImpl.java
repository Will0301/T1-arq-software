package edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.repositoriosImpl;

import edu.pucrs.arquiteturasoftwaret1.domain.repository.IAplicativoRepository;
import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.entidades.AplicativoEntity;
import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.interfaceJPA.AplicativosRepository_ItfRep;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class AplicativoRepImpl implements IAplicativoRepository {

    private AplicativosRepository_ItfRep aplicativosRepositoryItfRep;

    @Override
    public void cadastrarApp(AplicativoEntity aplicativo) {
        aplicativosRepositoryItfRep.save(aplicativo);
    }

    @Override
    public void editarApp(AplicativoEntity aplicativo) {
        final var oldApp = aplicativosRepositoryItfRep.findById(aplicativo.getCodigo()).orElse(null);
        if (oldApp != null) {
            aplicativosRepositoryItfRep.save(aplicativo);
        }
    }

    @Override
    public List<AplicativoEntity> listarApps() {
        final var appLists = aplicativosRepositoryItfRep.findAll();
        if (appLists.isEmpty()) return List.of(AplicativoEntity.builder().build());
        return appLists;
    }

    @Override
    public List<AplicativoEntity> listarBy(String filter) {
        return List.of(AplicativoEntity.builder().build());
    }

    @Override
    public AplicativoEntity atualizarCusto(Long idAplicativo, Double novoCusto){
        AplicativoEntity app = aplicativosRepositoryItfRep.findById(idAplicativo).orElse(null);
        if (app != null) {
            app.setCusto(novoCusto);
            return aplicativosRepositoryItfRep.save(app);
        } else return app;
    }
}
