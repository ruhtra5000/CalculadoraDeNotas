package br.com.calculadoranota.calculadoranota.exception;

public class ModoInvalidoException extends Exception{
    public ModoInvalidoException(){
        super("O calculo selecionado não é válido.");
    }
}
