package edu.pucrs.arquiteturasoftwaret1.domain.servicos;

import edu.pucrs.arquiteturasoftwaret1.domain.repository.IClienteRepository;
import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.entidades.ClienteEntity;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private IClienteRepository clienteRepository;

    public void cadastrarCliente(ClienteEntity cliente) {
        clienteRepository.cadastrarCliente(cliente);
    }

    public void editarCliente(ClienteEntity cliente) throws BadRequestException {
        clienteRepository.editarCliente(cliente);
    }

    public List<ClienteEntity> listarClientes() {
        return clienteRepository.listarClientes();
    }

    public List<ClienteEntity> listarBy(String filter) {
        return clienteRepository.listarBy(filter);
    }
}
