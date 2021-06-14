#include <stdio.h>
#include <stdlib.h>

int main() {
  int quantidades, tamanhos;

  int mediasSolicitadas = 0; 
  int pequenasSolicitadas  = 0;

  int mediasProduzidas;
  int pequenasProduzidas;

  // Recebemos a quantidade de blusas solicitadas
  printf("Digite o numero de premiados: ");
  scanf("%i", &quantidades);

  // Em um loop com a quantidade de blusas solicitadas
  for(int idx; idx<quantidades; idx++) {
    printf("Tamanho da %ia camisa: ", idx + 1);

    // Pegamos o tamanho da blusa em questão enquanto for diferente de 1 e 2
    do scanf("%i", &tamanhos); while(tamanhos != 1 && tamanhos != 2);
    
    // somamos as varaiveis de tamanhos solicitados em seu respectivo tamanho
    tamanhos == 2 ? mediasSolicitadas ++ : pequenasSolicitadas ++;
  }

  // Recebemos as quantidades produzidas de cada tamanho
  printf("Camisetas pequenas produzidas: ");
  scanf("%i", &pequenasProduzidas);

  printf("Camisetas medias produzidas: ");
  scanf("%i", &mediasProduzidas);

  // Verificamos se a quantidades produzidas atendem as solicitadas
  if((pequenasSolicitadas - pequenasProduzidas) <= 0 && (mediasSolicitadas - mediasProduzidas) <= 0) {
    printf("\nS");
  } else { 
    printf("\nN");
  }
  
  printf("\n\n");
  return 0;
}