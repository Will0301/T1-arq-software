package edu.pucrs.arquiteturasoftwaret1.domain.repository;

import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.entidades.ClienteEntity;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface IClienteRepository {
    void cadastrarCliente(ClienteEntity aplicativo);
    void editarCliente(ClienteEntity cliente) throws BadRequestException;
    List<ClienteEntity> listarClientes();
    List<ClienteEntity> listarBy(String filter);
}
