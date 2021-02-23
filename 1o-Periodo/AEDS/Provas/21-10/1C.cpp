#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    int quant,i;
    printf("Numero de Produtos:");
    scanf("%i",&quant);
    
    struct aplicativo{
        int codigo;
        int quantidade;
        float valor;
    }aplicativo[quant];

    struct aplicativo produto[5];
    float total;

    for(i=0; i<quant; i++){

        printf("\n\nCodigo:   ");
        scanf("%d", &produto[i].codigo);

        printf("Quantidade:   ");
        scanf("%d", &produto[i].quantidade);

        printf("Valor:   ");
        scanf("%f", &produto[i].valor);

        total = total + (produto[i].quantidade * produto[i].valor);
    }

  printf("\nTotal:%f  \n", total);
  return(0);

}