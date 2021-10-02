package aula0110.computador;

/**
 * Crie uma classe Computador que possua os parâmetros tamanho da HD, tamanho da
 * RAM, número de processadores e fabricante. Crie métodos de acesso público e
 * reimplemente o método toString() da classe. Crie um construtor para passar
 * todos os atributos durante a criação do objeto.
 * 
 * Crie o atributo booleano ligado e um método para ligar e desligar o
 * computador. Todo computador quando for criado deve estar desligado. Crie o
 * método estadoComputador que retorna se ele está ligado ou desligado.
 * 
 * Crie uma classe TestaComputador. Crie nesta classe um array de 3 computadores
 * que irá receber os dados do computador pelo usuário. Depois imprima os dados
 * dos computadores que possuem mais que 512Mb de Ram usando o método toString.
 * 
 * Se conseguir fazer o cadastro por menu é muito bom. Boa sorte.
 */

public class Computador {
  private double tamanhoHD;
  private double tamanhoRAM;
  private int numeroProcessadores; 
  private String fabricante;
  private boolean ligado;

  public Computador(double tamanhoHD, double tamanhoRAM, int numeroProcessadores, String fabricante) {
    setTamanhoHD(tamanhoHD);
    setTamanhoRAM(tamanhoRAM);
    setNumeroProcessadores(numeroProcessadores);
    setFabricante(fabricante);
    desligarComputador();
  }

  public double getTamanhoHD() {
    return tamanhoHD;
  }

  public void setTamanhoHD(double tamanhoHD) {
    if (tamanhoHD <= 0) return;
    
    this.tamanhoHD = tamanhoHD;
  }

  public double getTamanhoRAM() {
    return tamanhoRAM;
  }

  public void setTamanhoRAM(double tamanhoRAM) {
    if (tamanhoRAM <= 0) return;
    
    this.tamanhoRAM = tamanhoRAM;
  }

  public int getNumeroProcessadores() {
    return numeroProcessadores;
  }

  public void setNumeroProcessadores(int numeroProcessadores) {
    if (numeroProcessadores <= 0) return;

    this.numeroProcessadores = numeroProcessadores;
  }

  public String getFabricante() {
    return fabricante;
  }

  public void setFabricante(String fabricante) {
    if (fabricante.isBlank()) return;

    this.fabricante = fabricante;
  }

  public void ligarComputador() {
    ligado = true;
  }

  public void desligarComputador() {
    ligado = false;
  }

  @Override
  public String toString() {
    return "Computador [fabricante=" + fabricante + ", ligado=" + ligado + ", numeroProcessadores="
        + numeroProcessadores + ", tamanhoHD=" + tamanhoHD + ", tamanhoRAM=" + tamanhoRAM + "]";
  }

    
}
