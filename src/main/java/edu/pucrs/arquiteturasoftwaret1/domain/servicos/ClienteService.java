package edu.pucrs.arquiteturasoftwaret1.domain.servicos;

import edu.pucrs.arquiteturasoftwaret1.aplicacao.dto.ClienteDTO;
import edu.pucrs.arquiteturasoftwaret1.domain.repository.IClienteRepository;
import edu.pucrs.arquiteturasoftwaret1.domain.servicos.mapper.ClientMapper;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private IClienteRepository clienteRepository;

    public void cadastrarCliente(ClienteDTO cliente) {
        clienteRepository.cadastrarCliente(ClientMapper.mapToEntity(cliente));
    }

    public void editarCliente(ClienteDTO cliente) throws BadRequestException {
        clienteRepository.editarCliente(ClientMapper.mapToEntity(cliente));
    }

    public List<ClienteDTO> listarClientes() {
        return clienteRepository.listarClientes().stream()
                .map(ClientMapper::mapToDTO)
                .toList();
    }

    public List<ClienteDTO> listarBy(String filter) {
        return clienteRepository.listarBy(filter).stream()
                .map(ClientMapper::mapToDTO)
                .toList();
    }
}
