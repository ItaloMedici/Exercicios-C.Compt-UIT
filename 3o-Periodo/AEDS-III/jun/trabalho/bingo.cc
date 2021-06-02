#include<stdio.h>
#include<stdlib.h>

#define NULO 0

int main () {
  int qtdCartelas, qtdMaxNumeros, qtdColunas;

  printf("Quantidade de cartelas: ");
  scanf("%i", &qtdCartelas);

  printf("\nQuantidade de colunas: ");
  scanf("%i", &qtdColunas);

  printf("\nQuantidade maxima de numeros permitidos: ");
  scanf("%i", &qtdMaxNumeros);

  // Criamos nossa matriz com N linhas e K colunas
  int mtzCartelas[qtdCartelas][qtdColunas];

  // Populamos nossa matriz de cartelas
  for(int i = 0; i<qtdCartelas; i++){
    for(int j = 0; j<qtdColunas; j++){
      printf("Cartela %i, coluna %d: ", i+1, j+1);
      do scanf("%i", &mtzCartelas[i][j]); while (mtzCartelas[i][j] < 0 && mtzCartelas[i][j] > qtdMaxNumeros);
    }
    printf("\n");
  }

  // Imprimimos a matriz
  for(int i = 0; i<qtdCartelas; i++){
    printf("\n");
    for(int j = 0; j<qtdColunas; j++){
      printf("\t %i ", mtzCartelas[i][j]);
    }
  }

  printf("\n\n");

  // Criamos nosso array de numeros sorteador
  int numerosSorteados[qtdMaxNumeros];

  // Populamos nosso array com os numeros sorteados
  for(int i=0; i<qtdMaxNumeros; i++) {
    printf("\nDigite os numeros sorteados: ");
    scanf("%i", &numerosSorteados[i]);

    int cartelasVencedoras[qtdCartelas], bingos;

    // Verificamos toda matriz
    for(int j = 0; j<qtdCartelas; j++){
      int somaLinha = 0;
      for(int k = 0; k<qtdColunas; k++){

        // Caso a casa da matriz seja um numero sorteado, a populamos com NULO (0)
        if(mtzCartelas[j][k] == numerosSorteados[i]) {
          mtzCartelas[j][k] = NULO;
        }

        // Somamos a linha da matriz
        somaLinha += mtzCartelas[j][k];
      }
      // Caso a linha seja zerada temos um bingo 
      if(somaLinha == 0) {
        printf("\n\nCartela Vencedora: %i", j+1);
        return 0;
      }
    }
  }

  printf("\n\n");
  return 0;
}