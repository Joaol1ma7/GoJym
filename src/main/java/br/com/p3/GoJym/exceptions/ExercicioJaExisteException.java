package br.com.p3.GoJym.exceptions;

public class ExercicioJaExisteException extends RuntimeException {
    public ExercicioJaExisteException(){
        super("Exercício já existe no banco de dados.");
    }
}
