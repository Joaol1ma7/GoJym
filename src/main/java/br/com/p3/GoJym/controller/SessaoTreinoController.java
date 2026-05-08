package br.com.p3.GoJym.controller;

import br.com.p3.GoJym.dto.SessaoTreinoDTO;
import br.com.p3.GoJym.model.Usuario;
import br.com.p3.GoJym.service.SessaoTreinoService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public ResponseEntity<List<SessaoTreinoDTO>> listAllSessaoTreinoByUsuarioAutenticado() {
        Usuario usuarioLogado = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<SessaoTreinoDTO> sessaoTreinos = sessaoTreinoService.listAllSessaoTreinoByUserId(usuarioLogado.getId());
        return ResponseEntity.ok(sessaoTreinos);
    }
}
