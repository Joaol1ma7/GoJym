package br.com.p3.GoJym.repository;

import br.com.p3.GoJym.model.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {

    Optional<Exercicio> findByNome(String nome);
}
