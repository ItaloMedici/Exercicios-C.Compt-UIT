#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main () {
  char premiados[50];
  fgets(premiados, 50, stdin);
  int quantidade = atoi(strtok(premiados, " "));

  int mediasSolicitadas = 0;
  int pequenasSolicitadas = 0;

  char tamanhos[quantidade];

/*   fgets(tamanhos, quantidade, stdin);
  int tamanho = atoi(strtok(tamanhos, " ")); */

  //fgets(premiados, quantidade, stdin);

  for(int i = 0; i < quantidade; i++) {

    scanf("%[^ ]s", tamanhos);
    printf(" %d", atoi(tamanhos));

    atoi(tamanhos) == 2 ? mediasSolicitadas ++ : pequenasSolicitadas ++;

    scanf(" %[^ ]s", tamanhos);
  }
  printf("\n%d %d", mediasSolicitadas, pequenasSolicitadas);

  return 0;
}