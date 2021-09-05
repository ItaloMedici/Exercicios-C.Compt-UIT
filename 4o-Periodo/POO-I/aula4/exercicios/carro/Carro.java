
/**
 * Criar um projeto de carro (novamente), onde, quando acelerar o carro, caso
 * ele entre na reserva (10% ou menos do tanque), avisar o usuário. Criar o
 * campo velocidade máxima, e o carro deverá respeitar esse valor. Veja que
 * carros que tem motor mais potente gastam mais gasolina. Lembre-se que o carro
 * só anda ligado e com gasolina, que ele precisa abastecer, etc. Você é livre
 * para escolher os atributos do carro, mas alguns são obrigatórios, como
 * apresentado anteriormente. Ao criar o carro é preciso informar no construtor
 * o modelo, capacidade do tanque, velocidade máxima e potencia do motor(1.0,
 * 1.4, 1.8, etc). No método main, receba as informações iniciais do carro e
 * crie um menu para o usuário interagir com o carro como... acelerar frear
 * ligar abastecer etc....
 * 
 * Na aula do dia 10, será solicitado a alguns alunos a apresentação do projeto.
 */

public class Carro {
  private String modelo;

  private Double capacidadeTanque;
  private Double nivelTanque;

  private Double potenciaMotor;
  
  private Double velocidade;
  private Double velocidadeMaxima;

  private Boolean ligado;
  private Boolean reserva;

  public String getModelo() {
    return modelo;
  }

  private void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public Double getCapacidadeTanque() {
    return capacidadeTanque;
  }

  private void setCapacidadeTanque(Double capacidadeTanque) {
    if (capacidadeTanque > 0) {
      this.capacidadeTanque = capacidadeTanque;
    }
  }

  public Double getNivelTanque() {
    return nivelTanque;
  }

  private boolean podeAbastecer(Double nivelTanque) {
    return (this.nivelTanque + nivelTanque <= getCapacidadeTanque() && nivelTanque > 0);
  }

  public void abastecer(Double nivelTanque) {
    if (podeAbastecer(nivelTanque)){
      if (nivelTanque > capacidadeTanque) {
        this.nivelTanque = capacidadeTanque;
      } else {
        this.nivelTanque = nivelTanque;
      }
    }
  }

  public Double porcentagemNivelTanque() {
    return (nivelTanque * 100) / capacidadeTanque;
  }

  public Double getPotenciaMotor() {
    return potenciaMotor;
  }

  private void setPotenciaMotor(Double potenciaMotor) {
    if (potenciaMotor >= 1d && potenciaMotor <= 2d){
      this.potenciaMotor = potenciaMotor;
    }
  }

  public Double getVelocidade() {
    return velocidade;
  }

  private boolean podeAcelerar() {
    return (
      (velocidade + potenciaMotor <= velocidadeMaxima) && estaLigado() && (nivelTanque > 0d)
    );
  }

  public void acelerar() {
    if (podeAcelerar()){
      velocidade += potenciaMotor;
      nivelTanque -= potenciaMotor;
      checarReserva();
      checarTanque();
    } 
  }

  public void frear() {
    if (estaLigado() && (nivelTanque > 0d)) {
      velocidade -= potenciaMotor;
      nivelTanque -= potenciaMotor;
      checarReserva();
      checarTanque();
    }
  }

  private void checarTanque() {
    if (nivelTanque <= 0d) {  
      nivelTanque = 0d;
      velocidade = 0d;
      desligar();
    }
  }

  private void checarReserva() {
    Double nivelReserva = capacidadeTanque * 0.1;

    if (nivelTanque <= nivelReserva) {
      System.out.println("Chegou na Reserva!!");
      reserva = true;
    }
  }

  public Double getVelocidadeMaxima() {
    return velocidadeMaxima;
  }

  private void setVelocidadeMaxima(Double velocidadeMaxima) {
    if (velocidadeMaxima > 0d && velocidadeMaxima <= 400d) {
      this.velocidadeMaxima = velocidadeMaxima;
    }
  }

  public Boolean estaLigado() {
    return ligado;
  }

  public void ligar() {
    ligado = true;
  }

  public void desligar() {
    ligado = false;
  }

  public void printCarro() {
    System.out.println("\tFicha carro"
      + "\nModelo: " + modelo
      + "\nCapacidade do Tanque: " + capacidadeTanque
      + "\nNível do tanque: " + nivelTanque
      + "\n% nível tanque: " + porcentagemNivelTanque() + "%"
      + (reserva ? "\nTanque na reserva! " : "")
      + "\nValocidade Máxima: " + velocidadeMaxima
      + "\nVelocidade atual: " + velocidade
      + "\nCarro " + (estaLigado() ? "ligado" : "desligado")
    );
  }

  public Carro () {
    modelo = "";
    capacidadeTanque = 100d;
    nivelTanque = 0d;
    potenciaMotor = 1d;
    velocidadeMaxima = 100d; 
    velocidade = 0d;
    reserva = false;
    ligado = false;
  }

  public Carro (String modelo, Double capacidadeTanque, Double velocidadeMaxima, Double potenciaMotor) { 
    this();
    setModelo(modelo);
    setCapacidadeTanque(capacidadeTanque);
    setPotenciaMotor(potenciaMotor);
    setVelocidadeMaxima(velocidadeMaxima);
  }
}
