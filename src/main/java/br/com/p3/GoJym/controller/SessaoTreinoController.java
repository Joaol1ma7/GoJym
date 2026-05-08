package br.com.p3.GoJym.controller;

import br.com.p3.GoJym.dto.SessaoTreinoDTO;
import br.com.p3.GoJym.model.SessaoTreino;
import br.com.p3.GoJym.service.SessaoTreinoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/workouts")
public class SessaoTreinoController {
    private final SessaoTreinoService sessaoTreinoService;

    public SessaoTreinoController(
            SessaoTreinoService sessaoTreinoService
    ){
        this.sessaoTreinoService=sessaoTreinoService;
    }

    @GetMapping
    public ResponseEntity<List<SessaoTreinoDTO>> listAllSessaoTreinoById(@RequestParam(name="id") UUID id) {
        List<SessaoTreinoDTO> sessaoTreinos = sessaoTreinoService.listAllSessaoTreinoByUserId(id);
        return ResponseEntity.ok(sessaoTreinos);
    }



}
