/*
    O apresentador Sílvio Santos divertia seu auditório com a brincadeira do pim, onde a pessoa deveria dizer os números de 1 a 50, mas trocando os múltiplos de 4 e 7 pela palavra pim. Faça um algoritmo que escreva esta sequencia. Além disso o programa não deve imprimir o número 13, pois 13 é galo e não merece aparecer na prova. Caso acertem, vocês receberão pontos, que valem mais que barras de ouro.
*/

#include<stdlib.h>
#include<stdio.h>

int main () {
    int i, num;

    do{
        printf("Digite um  numero entre 0 e 50: ");
        scanf("%d", &num); 
    }while(num>50);

    if(num%4 == 0 || num%7 == 0){
        printf("pim");
    }

    else if(num==13){
        printf("KKKKKK");
    }

    else{
        printf("%d", num);
    }


    printf("\n\n");
    system("pause");
    return 0;
}




