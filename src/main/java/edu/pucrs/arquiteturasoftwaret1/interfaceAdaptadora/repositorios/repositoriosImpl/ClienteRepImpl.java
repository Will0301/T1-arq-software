package edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.repositoriosImpl;

import edu.pucrs.arquiteturasoftwaret1.domain.repository.IClienteRepository;
import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.entidades.ClienteEntity;
import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.interfaceJPA.ClienteRepository_ItfRep;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class ClienteRepImpl implements IClienteRepository {

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
