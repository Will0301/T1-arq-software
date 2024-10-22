package edu.pucrs.arquiteturasoftwaret1.contract;

import edu.pucrs.arquiteturasoftwaret1.domain.entities.PagamentoEntity;
import edu.pucrs.arquiteturasoftwaret1.usecase.PagamentoService;
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
    public ResponseEntity<PagamentoEntity> registrarPagamento(@RequestBody PagamentoEntity pagamento) {
        PagamentoEntity novoPagamento = pagamentoService.registrarPagamento(pagamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPagamento);
    }
}