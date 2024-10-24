package edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.controladores;

import edu.pucrs.arquiteturasoftwaret1.aplicacao.dto.AssinaturaDTO;
import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.entidades.AssinaturaEntity;
import edu.pucrs.arquiteturasoftwaret1.domain.servicos.AssinaturaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/servcad")
public class AssinaturaController {

    private final AssinaturaService assinaturaService;

    @PostMapping("/assinaturas")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AssinaturaDTO> criarAssinatura(@RequestBody AssinaturaDTO assinatura) {
        AssinaturaEntity novaAssinatura = assinaturaService.criarAssinatura(assinatura);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaAssinatura);
    }

    @GetMapping("/assinaturas/{tipo}")
    public ResponseEntity<List<AssinaturaDTO>> listarAssinaturasPorTipo(@PathVariable String tipo) {
        List<AssinaturaDTO> assinaturas = assinaturaService.listarAssinaturasPorTipo(tipo);
        return ResponseEntity.ok(assinaturas);
    }

    @GetMapping("/asscli/{codcli}")
    public ResponseEntity<List<AssinaturaDTO>> listarAssinaturasPorCliente(@PathVariable Long codcli) {
        List<AssinaturaDTO> assinaturas = assinaturaService.listarAssinaturasPorCliente(codcli);
        return ResponseEntity.ok(assinaturas);
    }

    @GetMapping("/assapp/{codapp}")
    public ResponseEntity<List<AssinaturaDTO>> listarAssinaturasPorAplicativo(@PathVariable Long codapp) {
        List<AssinaturaDTO> assinaturas = assinaturaService.listarAssinaturasPorAplicativo(codapp);
        return ResponseEntity.ok(assinaturas);
    }

    @GetMapping("/assinvalida/{codass}")
    public ResponseEntity<Boolean> verificarAssinaturaValida(@PathVariable Long codass) {
        boolean isValida = assinaturaService.verificarAssinaturaValida(codass);
        return ResponseEntity.ok(isValida);
    }
}