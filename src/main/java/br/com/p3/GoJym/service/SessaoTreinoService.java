package br.com.p3.GoJym.service;

import br.com.p3.GoJym.dto.CreateSessaoTreinoDTO;
import br.com.p3.GoJym.dto.SessaoTreinoDTO;
import br.com.p3.GoJym.model.SessaoTreino;
import br.com.p3.GoJym.model.Usuario;
import br.com.p3.GoJym.repository.SessaoTreinoRepository;
import br.com.p3.GoJym.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SessaoTreinoService {
    private final SessaoTreinoRepository sessaoTreinoRepository;
    private final UsuarioRepository usuarioRepository;

    public SessaoTreinoService(SessaoTreinoRepository sessaoTreinoRepository, UsuarioRepository usuarioRepository) {
        this.sessaoTreinoRepository = sessaoTreinoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<SessaoTreinoDTO> listAllSessaoTreinoByUserId(UUID id){
        return sessaoTreinoRepository.findAllByUsuarioId(id);
    }

    public SessaoTreinoDTO createSessaoTreinoByUserId(UUID id, CreateSessaoTreinoDTO createSessaoTreinoDTO) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        SessaoTreino sessaoTreino = new SessaoTreino();
        sessaoTreino.setUsuario(usuario);
        sessaoTreino.setNome(createSessaoTreinoDTO.getNome());
        SessaoTreino sessaoTreinoSalva= sessaoTreinoRepository.save(sessaoTreino);

        return sessaoTreinoDTOMapper(sessaoTreinoSalva);
    }
    private SessaoTreinoDTO sessaoTreinoDTOMapper(SessaoTreino sessaoTreinoSalva){
        return new SessaoTreinoDTO(
                sessaoTreinoSalva.getId(),
                sessaoTreinoSalva.getNome(),
                sessaoTreinoSalva.getCreatedAt(),
                0);
    }
}





