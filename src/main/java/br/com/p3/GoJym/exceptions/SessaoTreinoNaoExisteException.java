package br.com.p3.GoJym.exceptions;

public class SessaoTreinoNaoExisteException extends RuntimeException {
    public SessaoTreinoNaoExisteException() {
        super("Sessão de treino não encontrada.");
    }

}
