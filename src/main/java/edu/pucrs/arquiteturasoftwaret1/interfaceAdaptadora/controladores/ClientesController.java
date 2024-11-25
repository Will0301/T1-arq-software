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

@Controller("/servcad/cliente")
@RequiredArgsConstructor
public class ClientesController {

    private ClienteService clienteService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarCliente(@RequestBody ClienteDTO aplicativoEntity){
        clienteService.cadastrarCliente(aplicativoEntity);
    }

    @GetMapping()
    public ResponseEntity<List<ClienteDTO>> ListarClientes(){
        return ResponseEntity.ok(clienteService.listarClientes());
    }

    @DeleteMapping
    public void excluirCliente(@RequestParam long codCliente){

    }

}
