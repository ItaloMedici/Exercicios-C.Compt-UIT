package aula4.exercicios.celular;

import java.util.Random;
import java.util.Scanner;

/**
 * Criar uma classe celular com os seguintes campos: modelo, nivelBateria,
 * ligado (tipo boolean) e som. O usuário pode carregar o celular, aumentar e
 * diminuir o som e jogar, ao jogar ele poderá escolher o jogo e a bateria
 * deverá gastar quando jogar. O jogo deverá ser um par ou impar onde o usuário
 * escolher (par ou impar) e o sistema gera um número aleatorio e diz se ganhou
 * ou perdeu. O usuário somente poderá controlar o som e jogar se o celular
 * estiver ligado. Criar uma classe TestaCelular e criar um menu para o usuário
 * interagir.
 * 
 * Modifique a classe celular e altere o jogo para poder jogar Pedra, Papel e
 * Tesoura. Também deverá ser criado um campo Id celular que deverá ser
 * incrementado automaticamente e também um método estático
 * mostraQtdeCelulares() que retorna quantos celulares estão instanciados!
 */

public class Celular {
  private String modelo;
  private Double nivelBateria;
  private Boolean ligado;
  private Double nivelSom;

  public int idCelular;
  public static int qtdCelulares = 0;

  public static int mostraQtdeCelulares() {
    return qtdCelulares;
  }

  private final Double gastoBateria = 10d;
  private Scanner s = new Scanner(System.in);

  private void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public String getModelo() {
    return modelo;
  }

  public void ligar() {
    if (nivelBateria <= 0) {
      System.out.println("Sem bateria!");
      return;
    }
    ligado = true;
  }

  public void desligar() {
    ligado = false;
  }

  public boolean isLigado() {
    return ligado;
  }

  private void usarBateria() {
    nivelBateria -= gastoBateria;
    checarBateria();
  }

  private void checarBateria() {
    if (nivelBateria <= 0) {
      ligado = false;
      nivelSom = 0d;
      nivelBateria = 0d;
    }
  }

  public void carregarBateria() {
    nivelBateria += gastoBateria;
  }

  public void carregarCompletamente() {
    while (nivelBateria < 100) {
      carregarBateria();
    }
  }

  public void aumentarVolume() {
    if (!isLigado() || nivelSom >= 100) {
      System.out.println("Sem bateria ou volume máximo");
      return;
    }
    nivelSom += 5;
  }

  public void diminuirVolume() {
    if (!isLigado() || nivelSom <= 0) {
      System.out.println("Sem bateria ou volume zerado");
      return;
    }

    nivelSom -= 5;
  }

  public void jogarParImpar() {
    if (!isLigado() || nivelBateria < gastoBateria) {
      System.out.println("Sem bateria suficiente ou desligado!");
      return;
    }
    short choice = 2;

    while (choice > 1 || choice < 0) {
      System.out.println("\n\tJOGO \nEscolha [0 - Impar | 1 - Par]: ");
      choice = s.nextShort();
    }

    int num = getRandomNumber(100);

    System.out.println((isPar(num) && choice == 1) || (!isPar(num) && choice == 0)
        ? "\n\tNumero: " + num + "\nParabéns você venceu! :D\n\n"
        : "\n\tNumero: " + num + "\nNão foi dessa vez :(\n\n");

    usarBateria();
  }

  private int getRandomNumber(int qtd) {
    Random r = new Random();
    return r.nextInt(qtd);
  }

  private boolean isPar(int num) {
    return num % 2 == 0;
  }

  public void printCelular() {
    System.out.println("\n\tFicha Técnica" + "\nModelo: " + modelo + "\nNível da bateria: " + nivelBateria + "%"
        + "\nNivel do som: " + nivelSom + "%" + "\nCelular " + (ligado ? "ligado" : "desligado") + "\n");
  }

  public void jogarPapelTesoura(int joagadaUsuario) {
    if (!isLigado() || nivelBateria < gastoBateria) {
      System.out.println("Sem bateria suficiente ou desligado!");
      return;
    }

    usarBateria();

    int joagadaPc = getRandomNumber(3);

    final int pedra = 0;
    final int papel = 1;
    final int tesoura = 2;

    switch (joagadaUsuario) {

      case pedra:
        switch (joagadaPc) {

          case pedra:
            System.out.println("Empate :/");
            break;

          case tesoura:
            System.out.println("Parabéns você venceu! :D");
            break;

          case papel:
            System.out.println("Não foi dessa vez :(");
            break;
        }
        break;

      case papel:
        switch (joagadaPc) {

          case pedra:
            System.out.println("Parabéns você venceu! :D");
            break;

          case tesoura:
            System.out.println("Não foi dessa vez :(");
            break;

          case papel:
            System.out.println("Empate :/");
            break;
        }
        break;

      case tesoura:
        switch (joagadaPc) {

          case pedra:
            System.out.println("Não foi dessa vez :(");
            break;

          case tesoura:
            System.out.println("Empate :/");
            break;

          case papel:
            System.out.println("Parabéns você venceu! :D");
            break;
        }
        break;
    }
  }

  public Celular(String modelo) {
    nivelBateria = 0d;
    nivelSom = 100d;
    desligar();
    setModelo(modelo);
    qtdCelulares++;
    idCelular = qtdCelulares;
  }
}
