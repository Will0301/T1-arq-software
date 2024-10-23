package edu.pucrs.arquiteturasoftwaret1.domain.repository;

import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.entidades.AssinaturaEntity;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface IAssinaturaRepository {
    AssinaturaEntity criarAssinatura(AssinaturaEntity assinatura);
    List<AssinaturaEntity> listarAssinaturasPorTipo(String tipo);
    List<AssinaturaEntity> listarAssinaturasPorCliente(Long codcli);
    List<AssinaturaEntity> listarAssinaturasPorAplicativo(Long codapp);
    boolean verificarAssinaturaValida(Long codass) throws BadRequestException;
}
