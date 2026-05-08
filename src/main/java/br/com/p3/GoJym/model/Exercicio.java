package br.com.p3.GoJym.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "exercicio")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exercicio {

    @Id
    @Column(nullable = false, updatable = false)
    private String id;

    @Column(nullable = false)
    private String nome;

}