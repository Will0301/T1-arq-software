package edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.controladores;

import edu.pucrs.arquiteturasoftwaret1.aplicacao.dto.PagamentoDTO;
import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.entidades.PagamentoEntity;
import edu.pucrs.arquiteturasoftwaret1.domain.servicos.PagamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/servcad")
public class PagamentoController {

    private final PagamentoService pagamentoService;

    @PostMapping("/registrarpagamento")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PagamentoDTO> registrarPagamento(@RequestBody PagamentoDTO pagamento) {
        PagamentoDTO novoPagamento = pagamentoService.registrarPagamento(pagamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPagamento);
    }
}