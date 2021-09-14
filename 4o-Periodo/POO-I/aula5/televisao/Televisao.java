package aula5.televisao;

/**
 * Crie uma classe Televisao com métodos que podem controlar o volume e trocar
 * os canais da televisão. A TV só funciona ligada e deve ter limites de volume
 * e canais. Os canais ao chegar no último volta para o primeiro. Crie os
 * seguintes controles: aumentar ou diminuir a potência do volume de som em uma
 * unidade de cada vez; aumentar e diminuir o número do canal em uma unidade
 * trocar para um canal indicado ou subir um canal caso não seja informado o
 * canal; consultar o valor do volume de som e o canal selecionado. Crie dois
 * construtores para a TV, um que recebe apenas a marcad da TV e outro que
 * recebe a marca, quantidade de canais e volume máximo. Crie o método toString
 * que mostrará a marca da TV, o volume e o canal atual. Crie menu para
 * interagir com a TV. Utilize métodos Get e Set.
 */

public class Televisao {
  private Double volumeAtual;
  private Double volumeMaximo;
  private Integer quantidadeCanais;
  private Integer canalAtual;
  private String marcaTv;
  private Boolean ligada;

  public Double getVolumeAtual() {
    if (!ligada) {
      System.out.println("TV desligada");
      return 0d;
    }
    return volumeAtual;
  }

  public void aumentarVolume() {
    if (!ligada || volumeAtual >= volumeMaximo) return;
    volumeAtual++;
  }

  public void abaixarVolume() {
    if (!ligada || volumeAtual <= 0d) return;
    volumeAtual--;
  }

  public Double getVolumeMaximo() {
    return volumeMaximo;
  }

  private void setVolumeMaximo(Double volumeMaximo) {
    this.volumeMaximo = volumeMaximo;
  }

  public Integer getQuantidadeCanais() {
    return quantidadeCanais;
  }

  private void setQuantidadeCanais(Integer quantidadeCanais) {
    this.quantidadeCanais = quantidadeCanais;
  }

  public String getMarcaTv() {
    return marcaTv;
  }

  private void setMarcaTv(String marcaTv) {
    this.marcaTv = marcaTv;
  }

  public void ligarTv() {
    ligada = true;
  }

  public void desligarTv() {
    ligada = false;
  }

  public Integer getCanalAtual() {
    if (!ligada) {
      System.out.println("TV desligada");
      return 0;
    }
    return canalAtual;
  }
  
  /*
    0 % 5 -> 0 + 1 = 1
    1 % 5 -> 1 + 1 = 2
    2 % 5 -> 2 + 1 = 3
    3 % 5 -> 3 + 1 = 4
    4 % 5 -> 4 + 1 = 5
    5 % 5 -> 0 + 1 = 1 
  */
  
  public void subirCanal() {
    if (!ligada) return;

    canalAtual = (canalAtual % quantidadeCanais) + 1;    
  }

  public void descerCanal() {
    if (!ligada) return;

    canalAtual = (canalAtual % quantidadeCanais) - 1;    
  }

  public void procurarCanal(Integer canalAtual) {
    if (canalAtual > quantidadeCanais || canalAtual < 0) {
      System.out.println("Canal não existente");
      return;
    }
    this.canalAtual = canalAtual;
  }

  

  @Override
  public String toString() {
    return ""
      + "\nMarca: " + marcaTv 
      + "\nCanal Atual: " + canalAtual 
      + "\nQuantidade de Canais: " + quantidadeCanais
      + "\nVolume Atual: " + volumeAtual  + "%"
      + "\nVolume Máximo: " + volumeMaximo
      + "\nTelevisão " + (ligada ? "Ligada" : "Desliagada" );
  }

  private Televisao() {
    ligada = false;
    canalAtual = 1;
    volumeAtual = 0d;
  }
  
  public Televisao(Double volumeMaximo, Integer quantidadeCanais, String marcaTv) {
    this();
    setVolumeMaximo(volumeMaximo);
    setQuantidadeCanais(quantidadeCanais);
    setMarcaTv(marcaTv);
  }

  public Televisao(String marca) {
    this();
    setMarcaTv(marcaTv);
    setVolumeMaximo(100d);
    setQuantidadeCanais(10);
  }
}
