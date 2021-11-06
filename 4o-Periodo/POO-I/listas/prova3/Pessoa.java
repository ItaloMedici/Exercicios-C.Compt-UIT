package listas.prova3;

/**
 * Criar a classe pessoa com os atributos id, nome, altura, peso. Métodos Imc e
 * outros a sua escolha.
 * 
 * Criar a classe testa com o método main com o seguinte menu. Lembrando que os
 * dados devem ser manipulados em arquivo texto.
 * 
 * Cadastrar pessoa Mostrar dados da pessoa buscando pelo id Mostrar pessoas
 * acima do peso
 * 
 * Obs. Os métodos de mostrar deverão buscar os dados do arquivo, instanciar em
 * uma pessoa e apresentar os dados pelo método toString.
 * 
 * Bom trabalho.
 */

public class Pessoa {
  private int id;
  private String nome;
  private Double altura;
  private Double peso;

  private static int count = 1;

  public Pessoa(String nome, Double altura, Double peso) {
    this.id = count;
    this.nome = nome;
    this.altura = altura;
    this.peso = peso;
    count++;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Double getAltura() {
    return altura;
  }

  public void setAltura(Double altura) {
    this.altura = altura;
  }

  public Double getPeso() {
    return peso;
  }

  public void setPeso(Double peso) {
    this.peso = peso;
  }

  public Double getImc() {
    return (peso / (altura * altura));
  }

  public boolean estaAcimaDoPeso() {
    return getImc() >= 30 ? true : false; 
  }

  @Override
  public String toString() {
    return this.id + ", " + this.nome + ", " + this.altura + ", " + this.peso + ", " + getImc();
  }
}
