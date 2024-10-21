package edu.pucrs.arquiteturasoftwaret1.usecase;

import edu.pucrs.arquiteturasoftwaret1.domain.entities.ClienteEntity;
import edu.pucrs.arquiteturasoftwaret1.domain.repository.ClienteRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public void cadastrarCliente(ClienteEntity aplicativo) {
        clienteRepository.save(aplicativo);
    }

    public void editarCliente(ClienteEntity cliente) throws BadRequestException {
        clienteRepository.findById(cliente.getCodigo())
                .orElseThrow(() ->  new BadRequestException("Cliente não cadastrado"));
        clienteRepository.save(cliente);
    }

    public List<ClienteEntity> listarClientes() {
        return List.of(ClienteEntity.builder().build());
    }

    public List<ClienteEntity> listarBy(String filter) {
        return List.of(ClienteEntity.builder().build());
    }
}
