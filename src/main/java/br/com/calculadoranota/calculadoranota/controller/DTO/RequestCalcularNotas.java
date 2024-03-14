package br.com.calculadoranota.calculadoranota.controller.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;

public class RequestCalcularNotas {
    private String nota1VA;

    @JsonInclude(JsonInclude.Include.NON_NULL) 
    private String nota2VA = "";

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nota3VA = "";
    

    public String getNota1VA() {
        return this.nota1VA;
    }
    public void setNota1VA(String nota1VA) {
        this.nota1VA = nota1VA;
    }

    public String getNota2VA() {
        return this.nota2VA;
    }
    public void setNota2VA(String nota2VA) {
        this.nota2VA = nota2VA;
    }

    public String getNota3VA() {
        return this.nota3VA;
    }

    public void setNota3VA(String nota3VA) {
        this.nota3VA = nota3VA;
    }

}
