package edu.pucrs.arquiteturasoftwaret1.domain.repository;

import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.entidades.AplicativoEntity;

import java.util.List;

public interface IAplicativoRepository {
    void cadastrarApp(AplicativoEntity aplicativo);
    void editarApp(AplicativoEntity aplicativo);
    List<AplicativoEntity> listarApps();
    AplicativoEntity atualizarCusto(Long idAplicativo, Double novoCusto);
    List<AplicativoEntity> listarBy(String filter);
}
