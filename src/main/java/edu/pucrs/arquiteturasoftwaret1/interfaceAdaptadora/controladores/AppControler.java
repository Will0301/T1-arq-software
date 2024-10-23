package edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.controladores;

import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.entidades.AplicativoEntity;
import edu.pucrs.arquiteturasoftwaret1.domain.servicos.AplicativoService;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller("/apps")
public class AppControler {

    private AplicativoService aplicativoService;

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastraAplicativo(@RequestBody AplicativoEntity app){
        aplicativoService.cadastrarApp(app);
    }

//    @PostMapping("/editar")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void editarAplicativo(@RequestBody AplicativoEntity app) throws BadRequestException {
//        aplicativoService.(app);
//    }

    @GetMapping("/listar")
    public ResponseEntity<List<AplicativoEntity>> ListarAplicativos(){
        return ResponseEntity.ok(aplicativoService.listarApps());
    }

    @PostMapping("/atualizacusto/{idAplicativo}")
    public ResponseEntity<AplicativoEntity> atualizarCusto(@PathVariable Long idAplicativo, @RequestBody Double novoCusto) {
        AplicativoEntity app = aplicativoService.atualizarCusto(idAplicativo, novoCusto);
        return ResponseEntity.ok(app);
    }
}
