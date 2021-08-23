package aula2.exercicios.pessoa;

import utils.FormatterUtil;

/* 
 * Ex 04  
 * Escreva um código em Java que apresente a classe Pessoa, com atributos nome,
 * endereço e telefone e, o método imprimir (Imprime todos os dados da pessoa). O
 * método imprimir deve mostrar na tela os valores de todos os atributos. Não esqueça de
 * adicionar os métodos Get,s e Set's. Crie a classe TestaPessoa, instancie 2 pessoas e teste
 * os métodos. Veja que cada pessoa possui seus próprios atributos.
*/

public class Pessoa {
    private String nome;
    private String endereco;
    private String telefone;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void printPessoa() {
        System.out.println(""
            + "\nNome: " + nome
            + "\nEndereco: " + endereco
            + "\nTelefone: " + FormatterUtil.formatarTelefone(telefone));
    }

    public void setTelefone(String telefone) {
        if(telefone.length() == 11) {
            this.telefone = telefone;
        } else {
            System.out.println("O telefone deve possuir 11 carateres");
        }
    }
    
    public Pessoa() {
        nome = "";
        endereco = "";
        telefone = "XXXXXXXXXXX";
    }

    public Pessoa(String nome, String endereco, String telefone) {
        this();
        this.nome = nome;
        this.endereco = endereco;
        setTelefone(telefone);
    }
}
