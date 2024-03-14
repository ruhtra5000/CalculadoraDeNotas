package br.com.calculadoranota.calculadoranota.facade;

import org.springframework.stereotype.Service;

@Service
public class FacadeGeneral {

    public String calculateNota(String nota1, String nota2, String nota3){
        if(nota2.equals("") && nota3.equals("")){
            return calculateNotaSegundaVA(Double.parseDouble(nota1));
        }
        else if(nota3.equals("")){
            return calculateNotaTerceiraVA(Double.parseDouble(nota1), Double.parseDouble(nota2));
        }
        else {
            return calculateNotaFinal(Double.parseDouble(nota1), Double.parseDouble(nota2), 
            Double.parseDouble(nota3));
        }
    }
    
    private String calculateNotaSegundaVA(double nota1){
        String base = "Nota mínima para 2ª VA: ";
        double nota = 14 - nota1;
        if(nota > 10)
            nota = 10;
        base += Double.toString(nota);
        return base;
    }

    private String calculateNotaTerceiraVA(double nota1, double nota2){
        if(nota1 + nota2 >= 14)
            return "Você está aprovado! Sua média já é maior ou igual a 7.";

        String base = "Nota mínima para 3ª VA: ";
        double parcial = Math.max(nota1, nota2);
        double nota = 14 - parcial;
        if(nota > 10)
            nota = 10;
        base += Double.toString(nota);
        return base;
    }

    private String calculateNotaFinal(double nota1, double nota2, double nota3){
        double media = calculateAverage(nota1, nota2, nota3);
        if(media >= 7)
            return "Você está aprovado! Sua média já é maior ou igual a 7.";
        else if(media < 3)
            return "Você está reprovado! Sua média é menor que 3.";
        else {
            String base = "Nota mínima para final: ";
            double nota = 10 - media;
            base += Double.toString(nota);
            return base;
        }  
    }

    //Calcula a média das duas maiores notas. Função auxiliar do calculo da final
    private double calculateAverage(double nota1, double nota2, double nota3){
        double lista [] = {nota1, nota2, nota3};
        double temp;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2 - i; j++) {
                if (lista[j] > lista[j + 1]) {
                    // Swap
                    temp = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = temp;
                }
            }
        }

        temp = (lista[1]+lista[2])/2;
        return temp;
    }
}
