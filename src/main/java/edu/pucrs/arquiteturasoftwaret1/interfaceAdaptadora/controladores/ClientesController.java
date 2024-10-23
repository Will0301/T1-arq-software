package edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.controladores;

import edu.pucrs.arquiteturasoftwaret1.aplicacao.dto.ClienteDTO;
import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.entidades.ClienteEntity;
import edu.pucrs.arquiteturasoftwaret1.domain.servicos.ClienteService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ClientesController {

    private ClienteService clienteService;

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarCliente(@RequestBody ClienteDTO aplicativoEntity){
        clienteService.cadastrarCliente(aplicativoEntity);
    }

    @PostMapping("/editar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void editarDadosCliente(@RequestBody ClienteDTO aplicativoEntity) throws BadRequestException {
        clienteService.editarCliente(aplicativoEntity);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ClienteDTO>> ListarClientes(){
        return ResponseEntity.ok(clienteService.listarClientes());
    }
}
