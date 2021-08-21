package aula2.src;
/*
  Criar uma classe carro com os seguintes atributos
  ligado
  capacidadeTanque
  combustivel
  velocidade

  criar métodos adequados para a utilização de um carro
  e também um método que exibe os detalhes do carro.

  depois, criar uma classe aplicativo com o método main
  e instanciar dois carro.
  Testar estes carros rodando seus métodos..
  Você deve receber os dados do usuário com a classe Scanner
*/

import java.io.PrintStream;

public class Carro {
  private Boolean ligado;
  private Double combustivel;
  private Double litroPorKm;
  private Double capacidadeTanque;
  private Double velocidade;
  private Integer numeroPortas;

  public final PrintStream sout = System.out;

  private final String SEM_COMBUSTIVEL = "\nSem combustível";
  private final String CARRO_DESLIGADO = "\nO Carro esta desligado";
  private final String TANQUE_CHEIO = "\nTanque cheio";
  private final String NAO_FOI_POSSIVEL = "\nNão foi possivel acelerar";

  public Boolean isLigado() {
    return ligado;
  }

  public void ligar() {
    ligado = true;
  }

  public void desligar(){
    if(ligado) {
      ligado = false;
    } else {
      sout.println("Carro já esta desligado");
    }
  }

  public Boolean temCombustivel(){
    return combustivel > 0 ? true : false;
  }

  public Double getCombustivel() {
    return combustivel;
  }

  public void abastecer(Double combustivel) {
    if(capacidadeTanque >= (this.combustivel + combustivel)){
      this.combustivel += combustivel;
    } else {
      sout.println(TANQUE_CHEIO);
    }
  }

  public void setLitroPorKm(Double litroPorKm){
    this.litroPorKm = litroPorKm;
  }

  public void desabastecer(Double velocidade) {
    Double combustivelGasto = litroPorKm * velocidade;
    if(combustivel >= combustivelGasto) {
      combustivel -= combustivelGasto;
    } else {
      sout.println(SEM_COMBUSTIVEL);
      combustivel = 0d;
      desligar();
    }
  }
  
  public Double getCapacidadeTanque() {
    return capacidadeTanque;
  }

  public void setCapacidadeTanque(Double capacidadeTanque) {
    this.capacidadeTanque = capacidadeTanque;
  }
  
  public Double getVelocidade() {
    return velocidade;
  }

  public void acelerar(Double velocidade) {
    if((velocidade > 0) && ligado && temCombustivel()) {
      this.velocidade += velocidade;
      desabastecer(velocidade);
    } else {
      sout.println(
        !isLigado() ? CARRO_DESLIGADO : 
        !temCombustivel() ? SEM_COMBUSTIVEL : 
        NAO_FOI_POSSIVEL
      ); 
      
    }
  }

  public void desacelerar(Double velocidade) {
    if((velocidade <= this.velocidade) && ligado && temCombustivel()){
      this.velocidade -= velocidade;
      desabastecer(velocidade);
    } else {
      sout.println("Não foi possível reduzir a velocidade");
    }
  }

  public Integer getNumeroPortas() {
    return numeroPortas;
  }

  public void setNumeroPortas(Integer numeroPortas) {
    if (numeroPortas <= 4) {
      this.numeroPortas = numeroPortas;
    } 
  }

  public void imprimirCarro(){
    sout.println(""
      + "\nO carro esta: " + (isLigado() ? "Ligado" : "Desligado")
      + "\nCacidade de tanque: " + capacidadeTanque
      + "\nCombustivel atual: " + combustivel
      + "\nVelocidade Atual: " + velocidade
      + "\nNumero de Portas: " + numeroPortas
    );
  }

  public Carro(){
    ligado = false;
    combustivel = 0d;
    velocidade = 0d;
    numeroPortas = 4;
    capacidadeTanque = 100d;
    litroPorKm = 1d;
  }

  public Carro(Double combustivel, Double capacidadeTanque, Integer numeroPortas, Double litroPorKm) {
    this();
    this.combustivel = combustivel;
    this.capacidadeTanque = capacidadeTanque;
    this.numeroPortas = numeroPortas;
    this.litroPorKm = litroPorKm;
  }

  
}
