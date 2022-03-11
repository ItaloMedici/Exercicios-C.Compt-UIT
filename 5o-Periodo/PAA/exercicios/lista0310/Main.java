package exercicios.lista0310;

import java.util.ArrayList;
import java.util.List;

/**
 * Criar uma classe que inicializa um vetor e possui os seguintes métodos para
 * preenchimento:
 * 
 * -Crescente
 * -Decrescente
 * -Aleatório
 * 
 * Obs: No método aleatório, utilizar a função de setar a semente antes do laço
 * for, para que os resultados dos exercícios sejam os mesmos para todos alunos.
 * 
 * Criar um código que busque sequencialmente o valor 78 em um vetor. Testar com
 * vetores de tamanhos 50, 500 e 5000. Variar o teste com o vetor inicializado
 * de forma crescente, decrescente e aleatório com raiz 3 e números entre 0 e
 * 199.
 * 
 * Repetir os testes para busca binária. (menos aleatório).
 * 
 * Em todos testes mostrar a quantidade de comparações realizadas e tempo
 * relógio gasto.
 * 
 * Enviar um relatório pdf com o algoritmo e o quadro com os resultados. Fazer
 * uma análise e conclusão dos resultados. Não precisa ser grande.
 */

public class Main {
  public static void main(String[] args) {
    teste(50);
    teste(500);
    teste(5000);
  }

  private static void teste(int num) {
    PopuleteList pop = new PopuleteList(num);
    printRelatorio(pop, "\t===== TESTE " + num + " =====");
  }

  private static void printRelatorio(PopuleteList pop, String title) {
    System.out.println(title
      + "\nSequencial"
      + "\n------------------------------"
      + "\nCorrente:\t" + pop.find78(pop.crescente())
      + "\nDecrescente:\t" + pop.find78(pop.decrescente())
      + "\nAleatorio:\t" + pop.find78(pop.aleatorio())
      + "\n"
      + "\nBinario"
      + "\n------------------------------"
      + "\nCrescente:\t" + pop.find78Binary(pop.crescente())
      + "\nDecrescente:\t" + pop.find78Binary(pop.crescente())
      + "\n\n"
    );
  }
}
