package edu.pucrs.arquiteturasoftwaret1.domain.servicos;

import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.entidades.ClienteEntity;
import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.interfaceJPA.ClienteRepository_ItfRep;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private ClienteRepository_ItfRep clienteRepositoryItfRep;

    public void cadastrarCliente(ClienteEntity aplicativo) {
        clienteRepositoryItfRep.save(aplicativo);
    }

    public void editarCliente(ClienteEntity cliente) throws BadRequestException {
        clienteRepositoryItfRep.findById(cliente.getCodigo())
                .orElseThrow(() ->  new BadRequestException("Cliente não cadastrado"));
        clienteRepositoryItfRep.save(cliente);
    }

    public List<ClienteEntity> listarClientes() {
        return List.of(ClienteEntity.builder().build());
    }

    public List<ClienteEntity> listarBy(String filter) {
        return List.of(ClienteEntity.builder().build());
    }
}
