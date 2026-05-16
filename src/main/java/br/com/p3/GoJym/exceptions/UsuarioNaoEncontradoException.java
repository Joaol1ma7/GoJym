package br.com.p3.GoJym.exceptions;

public class UsuarioNaoEncontradoException extends RuntimeException {
    public UsuarioNaoEncontradoException(){
        super("Usuário não encontrado.");
    }
}
