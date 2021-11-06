package aula0510;

/**
 * Crie uma classe Animal que obedeça à seguinte descrição: possua os atributos
 * nome (String), comprimento (float), número de patas (int), cor (String),
 * ambiente (String) e velocidade média (float)  Crie um método construtor que
 * receba por parâmetro os valores iniciais de cada um dos atributos e
 * atribua-os aos seus respectivos atributos.  Crie os métodos get e set para
 * cada um dos atributos.  Sobreescreve o metodo toString(), que, quando
 * chamado, imprime na tela uma espécie de relatório informando os dados do
 * animal.
 */

public class Animal {
  private String nome;
  private float comprimento;
  private int numeroPatas;
  private String cor;
  private String ambiente;
  private float velocidadeMedia;

  public Animal(String nome, float comprimento, int numeroPatas, String cor, String ambiente, float velocidadeMedia) {
    this.nome = nome;
    this.comprimento = comprimento;
    this.numeroPatas = numeroPatas;
    this.cor = cor;
    this.ambiente = ambiente;
    this.velocidadeMedia = velocidadeMedia;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public float getComprimento() {
    return comprimento;
  }

  public void setComprimento(float comprimento) {
    this.comprimento = comprimento;
  }

  public int getNumeroPatas() {
    return numeroPatas;
  }

  public void setNumeroPatas(int numeroPatas) {
    this.numeroPatas = numeroPatas;
  }

  public String getCor() {
    return cor;
  }

  public void setCor(String cor) {
    this.cor = cor;
  }

  public String getAmbiente() {
    return ambiente;
  }

  public void setAmbiente(String ambiente) {
    this.ambiente = ambiente;
  }

  public float getVelocidadeMedia() {
    return velocidadeMedia;
  }

  public void setVelocidadeMedia(float velocidadeMedia) {
    this.velocidadeMedia = velocidadeMedia;
  }

  @Override
  public String toString() {
    return "Animal [ambiente=" + ambiente + ", comprimento=" + comprimento + ", cor=" + cor + ", nome=" + nome
        + ", numeroPatas=" + numeroPatas + ", velocidadeMedia=" + velocidadeMedia + "]";
  }
  
} 
