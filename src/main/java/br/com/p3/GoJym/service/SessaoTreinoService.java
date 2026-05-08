package br.com.p3.GoJym.service;

import br.com.p3.GoJym.dto.SessaoTreinoDTO;
import br.com.p3.GoJym.model.SessaoTreino;
import br.com.p3.GoJym.repository.SessaoTreinoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SessaoTreinoService {
    private final SessaoTreinoRepository sessaoTreinoRepository;

    public SessaoTreinoService(SessaoTreinoRepository sessaoTreinoRepository) {
        this.sessaoTreinoRepository = sessaoTreinoRepository;
    }

    public List<SessaoTreinoDTO> listAllSessaoTreinoByUserId(UUID id){
        return sessaoTreinoRepository.findAllByUsuarioId(id);
    }
}
