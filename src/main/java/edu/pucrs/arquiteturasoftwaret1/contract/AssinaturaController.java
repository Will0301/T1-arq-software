package edu.pucrs.arquiteturasoftwaret1.contract;

import edu.pucrs.arquiteturasoftwaret1.domain.entities.AssinaturaEntity;
import edu.pucrs.arquiteturasoftwaret1.usecase.AssinaturaService;
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
    public ResponseEntity<AssinaturaEntity> criarAssinatura(@RequestBody AssinaturaEntity assinatura) {
        AssinaturaEntity novaAssinatura = assinaturaService.criarAssinatura(assinatura);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaAssinatura);
    }

    @GetMapping("/assinaturas/{tipo}")
    public ResponseEntity<List<AssinaturaEntity>> listarAssinaturasPorTipo(@PathVariable String tipo) {
        List<AssinaturaEntity> assinaturas = assinaturaService.listarAssinaturasPorTipo(tipo);
        return ResponseEntity.ok(assinaturas);
    }

    @GetMapping("/asscli/{codcli}")
    public ResponseEntity<List<AssinaturaEntity>> listarAssinaturasPorCliente(@PathVariable Long codcli) {
        List<AssinaturaEntity> assinaturas = assinaturaService.listarAssinaturasPorCliente(codcli);
        return ResponseEntity.ok(assinaturas);
    }

    @GetMapping("/assapp/{codapp}")
    public ResponseEntity<List<AssinaturaEntity>> listarAssinaturasPorAplicativo(@PathVariable Long codapp) {
        List<AssinaturaEntity> assinaturas = assinaturaService.listarAssinaturasPorAplicativo(codapp);
        return ResponseEntity.ok(assinaturas);
    }

    @GetMapping("/assinvalida/{codass}")
    public ResponseEntity<Boolean> verificarAssinaturaValida(@PathVariable Long codass) {
        boolean isValida = assinaturaService.verificarAssinaturaValida(codass);
        return ResponseEntity.ok(isValida);
    }
}