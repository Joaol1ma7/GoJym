package br.com.p3.GoJym.exceptions;

public class ExercicioNotFoundException extends RuntimeException {
    public ExercicioNotFoundException() {
        super("Exercício não foi encontrado.");
    }
}
