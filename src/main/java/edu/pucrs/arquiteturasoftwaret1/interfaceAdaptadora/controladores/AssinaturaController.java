package edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.controladores;

import edu.pucrs.arquiteturasoftwaret1.aplicacao.dto.AssinaturaDTO;
import edu.pucrs.arquiteturasoftwaret1.aplicacao.usecase.ClienteUC;
import edu.pucrs.arquiteturasoftwaret1.aplicacao.usecase.EfetuarAssinatura;
import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.entidades.AssinaturaEntity;
import edu.pucrs.arquiteturasoftwaret1.domain.servicos.AssinaturaService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/servcad")
public class AssinaturaController {

    private final ClienteUC clienteUC;

//    @PostMapping("/assinaturas")
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<AssinaturaDTO> criarAssinatura(@RequestBody AssinaturaDTO assinatura) {
//    AssinaturaEntity novaAssinatura = assinaturaService.criarAssinatura(assinatura);
//    }

    @GetMapping("/assinaturas/{tipo}")
    public ResponseEntity<List<AssinaturaDTO>> listarAssinaturasPorTipo(@PathVariable String tipo) {
        List<AssinaturaDTO> assinaturas = clienteUC.listarAssinaturasPorStatus(tipo);
        return ResponseEntity.ok(assinaturas);
    }

    @GetMapping("/asscli/{codcli}")
    public ResponseEntity<List<AssinaturaDTO>> listarAssinaturasPorCliente(@PathVariable Long codcli) throws BadRequestException {
        List<AssinaturaDTO> assinaturas = clienteUC.listarAssinaturas(codcli);
        return ResponseEntity.ok(assinaturas);
    }

    @GetMapping("/assapp/{codapp}")
    public ResponseEntity<List<AssinaturaDTO>> listarAssinaturasPorAplicativo(@PathVariable Long codapp) {
        List<AssinaturaDTO> assinaturas = clienteUC.listarAssinaturasPorAplicativo(codapp);
        return ResponseEntity.ok(assinaturas);
    }

//    @GetMapping("/assinvalida/{codass}")
//    public ResponseEntity<Boolean> verificarAssinaturaValida(@PathVariable Long codass) {
//        boolean isValida = clienteUC.verificarAssinaturaValida(codass);
//        return ResponseEntity.ok(isValida);
//    }
}