package listas.prova2.arrayInteiros;

import java.util.Random;

/**
 * Escreva uma classe Principal que possui um array de inteiros de tamanho 10.
 * Preencha este vetor com números aleatórios. Após receber os números, escreva
 * os mesmos de forma ordenada.
 * 
 * @author Ítalo Médici
 */

public class Main {
  public static void main(String[] args) {
    int arrayInteiros[] = new int[10];

    for (int i = 0; i < arrayInteiros.length; i++) {
      arrayInteiros[i] = getRandomNumber();
    }

    arrayInteiros = sortArray(arrayInteiros);

    for (int num : arrayInteiros) {
      System.out.print(num + ", ");
    }
  }

  private static int getRandomNumber() {
    Random r = new Random();
    return r.nextInt(10);
  }

  private static int[] sortArray(int[] arrayInteiros) {
    for (int i = 0; i < arrayInteiros.length; i++) {
      for (int j = i + 1; j < arrayInteiros.length; j++) {
        int auxInt = 0;
        if (arrayInteiros[i] > arrayInteiros[j]) {
          auxInt = arrayInteiros[i];
          arrayInteiros[i] = arrayInteiros[j];
          arrayInteiros[j] = auxInt;
        }
      }
    }

    return arrayInteiros;
  }
}
