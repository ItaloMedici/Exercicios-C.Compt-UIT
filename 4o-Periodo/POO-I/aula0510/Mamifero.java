package aula0510;

/**
 * Crie uma classe Mamifero que herde da classe Animal e obedeça à seguinte
 * descrição:  possua um atributo alimento(String)  Crie um método construtor
 * que receba por parâmetro os valores iniciais de cada um dos atributos
 * (incluindo os atributos da classe Animal) e atribua-os aos seus respectivos
 * atributos.  Crie ainda os métodos get e set para o atributo alimento.  Crie
 * um método dadosMamifero sem parâmetro e do tipo void, que, quando chamado,
 * imprime na tela uma espécie de relatório informando os dados do mamifero
 * (incluindo os dados do Animal e mais o alimento).
 */

public class Mamifero extends Animal {
  private String alimento;

  public Mamifero(
      String nome, float comprimento, int numeroPatas, String cor, String ambiente, float velocidadeMedia,
      String alimento) {
    super(nome, comprimento, numeroPatas, cor, ambiente, velocidadeMedia);
    this.alimento = alimento;
  }

  public String getAlimento() {
    return alimento;
  }

  public void setAlimento(String alimento) {
    this.alimento = alimento;
  }

  @Override
  public String emitirSom() {
    return "som_de_mamifero.mp3";
  } 

  public String dadosMamifero() {
    return ("\tMamifero "
      + "\nAlimento: " + alimento
      + "\nNome: " + getNome()
      + "\nComprimento: " + getComprimento()
      + "\nNumero Patas: " + getNumeroPatas()
      + "\nCor: " + getCor()
      + "\nAmbiente: " + getAmbiente()
      + "\nVelocidade Media: " + getVelocidadeMedia()
      );
  }
}
