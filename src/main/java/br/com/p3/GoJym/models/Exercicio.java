package br.com.p3.GoJym.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "exercicio")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exercicio {

    // ID do tipo String — chave natural (ex.: "supino_reto"), sem geração automática
    @Id
    @Column(nullable = false, updatable = false)
    private String id;

    @Column(nullable = false)
    private String nome;

}