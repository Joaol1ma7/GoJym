package br.com.p3.GoJym.service;

import br.com.p3.GoJym.dto.SessaoTreinoDTO;
import br.com.p3.GoJym.repository.ExercicioRepository;
import br.com.p3.GoJym.repository.SessaoExercicioRepository;
import br.com.p3.GoJym.repository.SessaoTreinoRepository;
import br.com.p3.GoJym.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SessaoTreinoService {
    private final SessaoTreinoRepository sessaoTreinoRepository;
    private final UsuarioRepository usuarioRepository;
    private final SessaoExercicioRepository sessaoExercicioRepository;
    private final ExercicioRepository exercicioRepository;

    public SessaoTreinoService(SessaoTreinoRepository sessaoTreinoRepository,
                               UsuarioRepository usuarioRepository,
                               SessaoExercicioRepository sessaoExercicioRepository,
                               ExercicioRepository exercicioRepository) {
        this.sessaoTreinoRepository = sessaoTreinoRepository;
        this.usuarioRepository = usuarioRepository;
        this.sessaoExercicioRepository = sessaoExercicioRepository;
        this.exercicioRepository = exercicioRepository;
    }

    public List<SessaoTreinoDTO> listAllSessaoTreinoByUserId(UUID id){
        return sessaoTreinoRepository.findAllByUsuarioId(id);
    }


}





