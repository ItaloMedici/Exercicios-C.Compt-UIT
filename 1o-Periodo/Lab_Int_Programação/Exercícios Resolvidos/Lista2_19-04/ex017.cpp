/*
    Elabore um algoritmo que leia dois vetores de dez posições e faça a multiplicação dos elementos de mesmo índice, colocando o resultado em um terceiro vetor, que deve ser mostrado como saída.
*/

#include<stdlib.h>
#include<stdio.h>

int main () {
    int vetA[10], vetB[10], vetC[10], i, j;

    for(i=0;i<10;i++){
        printf("Digite o %do valor de A: ", i+1);
        scanf("%d", &vetA[i]);

        printf("Digite o %do valor de B: ", i+1);
        scanf("%d", &vetB[i]);
        printf("\n");
        vetC[i] = vetA[i]*vetB[i];
    }

    for(i=0;i<10;i++){
        printf("%d x %d = %d\n", vetA[i], vetB[i], vetC[i]);
    }

    printf("\n\n");
    system("pause");
    return 0;
}