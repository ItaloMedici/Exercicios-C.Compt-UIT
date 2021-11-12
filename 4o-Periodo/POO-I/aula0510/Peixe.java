package aula0510;

/**
 * Crie uma classe Peixe que herde da classe Animal e obedeça à seguinte
 * descrição:  possua um atributo caracteristica(String)  Crie um método
 * construtor que receba por parâmetro os valores iniciais de cada um dos
 * atributos (incluindo os atributos da classe Animal) e atribua-os aos seus
 * respectivos atributos.  Crie ainda os métodos get e set para o atributo
 * caracteristica.  Crie um método dadosPeixe sem parâmetro e do tipo void,
 * que, quando chamado, imprime na tela uma espécie de relatório informando os
 * dados do peixe (incluindo os dados do Animal e mais a característica).
 */

public class Peixe extends Animal {
  private String caracteristica;

  public Peixe(
      String nome, float comprimento, int numeroPatas, String cor, String ambiente, float velocidadeMedia,
      String caracteristica) {
    super(nome, comprimento, numeroPatas, cor, ambiente, velocidadeMedia);
    this.caracteristica = caracteristica;
  }

  public String getCaracteristica() {
    return caracteristica;
  }

  public void setCaracteristica(String caracteristica) {
    this.caracteristica = caracteristica;
  }
  
  @Override
  public String emitirSom() {
    return "blublbubu";
  } 

  public String dadosPeixe() {
    return ("\tPeixe "
      + "\nCaracteristica: " + caracteristica
      + "\nNome: " + getNome()
      + "\nComprimento: " + getComprimento()
      + "\nNumero Patas: " + getNumeroPatas()
      + "\nCor: " + getCor()
      + "\nAmbiente: " + getAmbiente()
      + "\nVelocidade Media: " + getVelocidadeMedia()
      );
  }
   
}
