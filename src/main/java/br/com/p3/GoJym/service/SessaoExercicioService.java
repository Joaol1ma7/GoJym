package br.com.p3.GoJym.service;


import br.com.p3.GoJym.dto.SessaoExercicioRequestDTO;
import br.com.p3.GoJym.dto.SessaoExercicioResponseDTO;
import br.com.p3.GoJym.model.Exercicio;
import br.com.p3.GoJym.model.SessaoExercicio;
import br.com.p3.GoJym.model.SessaoTreino;
import br.com.p3.GoJym.repository.ExercicioRepository;
import br.com.p3.GoJym.repository.SessaoExercicioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SessaoExercicioService {
    private final SessaoExercicioRepository sessaoExercicioRepository;
    private final ExercicioRepository exercicioRepository;

    public SessaoExercicioService(SessaoExercicioRepository sessaoExercicioRepository, ExercicioRepository exercicioRepository){
        this.sessaoExercicioRepository=sessaoExercicioRepository;
        this.exercicioRepository=exercicioRepository;
    }


    public List<SessaoExercicioResponseDTO> createSessoesExercicio(List<SessaoExercicioRequestDTO> requestDTO, SessaoTreino sessaoTreino){
        List<SessaoExercicioResponseDTO> exercicioResponseDTOS=new ArrayList<>();;
        for(SessaoExercicioRequestDTO exercicio : requestDTO){
                Exercicio exercicioReferenciado = exercicioRepository.findById(exercicio.getExercicioId()).orElse(null);

               SessaoExercicio sessaoExercicio = new SessaoExercicio();
               sessaoExercicio.setExercicio(exercicioReferenciado);
               sessaoExercicio.setSessaoTreino(sessaoTreino);
               sessaoExercicio.setDescanso(exercicio.getDescanso());
               sessaoExercicio.setRepeticoesMin(exercicio.getRepsMin());
               sessaoExercicio.setRepeticoesMax(exercicio.getRepsMax());
               sessaoExercicio.setOrdem(exercicio.getOrdem());
               sessaoExercicio.setNumSeries(exercicio.getSeries());
               SessaoExercicio sessaoExercicioSalva=sessaoExercicioRepository.save(sessaoExercicio);

               exercicioResponseDTOS.add(new SessaoExercicioResponseDTO(sessaoExercicioSalva.getId(), sessaoExercicioSalva.getExercicio().getNome(),  sessaoExercicioSalva.getNumSeries(),sessaoExercicioSalva.getRepeticoesMin(), sessaoExercicioSalva.getRepeticoesMax(), sessaoExercicioSalva.getOrdem(), sessaoExercicioSalva.getDescanso()));
           }
        return exercicioResponseDTOS;
    }
}
