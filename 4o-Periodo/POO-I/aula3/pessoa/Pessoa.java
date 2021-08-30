package aula3.pessoa;

/**
 * Crie uma classe para representar uma pessoa, com os atributos privados de
 * nome, sexo, peso e altura. Crie os métodos públicos necessários para sets e
 * gets e também um método para imprimir todos dados de uma pessoa. Crie um
 * método para calcular o imc da pessoa e outro método que retorne string se
 * está abaixo, acima ou no peso ideal. Faça o teste com duas pessoas passando
 * os valores por get e set.
 */

public class Pessoa {
    private String nome;
    private char sexo;
    private Double peso;
    private Double altura;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome.trim().length() > 0) {
            this.nome = nome;
        }
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        if(sexo =='f' || sexo == 'm') {
            this.sexo = sexo;
        }
    } 

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        if(peso > 0d) {
            this.peso = peso;
        }
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        if(altura > 0d && altura <= 2.50d) {
            this.altura = altura;
        }
    }

    public Double calcIMC() {
        return peso / (altura * altura);
    }

    public String getIMC() {
        Double imc = calcIMC();
        
        if(imc > 16){
            if(imc <= 17 )        return "Desnutrição Grau II";
            else if (imc <= 18.4) return "Desnutrição Grau I";
            else if (imc <= 24.9) return "Peso ideal";
            else if (imc <= 29.9) return "Sobrepeso";
            else if (imc <= 34.5) return "Obesidade Grau I";
            else if (imc <= 39.9) return "Obesidade Grau II";
            else return "Obesidade Grau II";
        } else {
            return "Desnutrição Grau III";
        }
    }

}
