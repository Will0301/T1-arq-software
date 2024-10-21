package edu.pucrs.arquiteturasoftwaret1.contract;

import edu.pucrs.arquiteturasoftwaret1.domain.entities.AplicativoEntity;
import edu.pucrs.arquiteturasoftwaret1.usecase.AplicativoService;
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

    @PostMapping("/editar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void editarAplicativo(@RequestBody AplicativoEntity app) throws BadRequestException {
        aplicativoService.editarApp(app);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<AplicativoEntity>> ListarAplicativos(){
        return ResponseEntity.ok(aplicativoService.listarApps());
    }
}
