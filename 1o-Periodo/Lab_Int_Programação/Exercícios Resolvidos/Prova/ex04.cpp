/*
    Faça um programa que imprima através de laço for aninhado a seguinte estrutura de números:
    9 8 7 6 5 4 3 2 1 0
    9 8 7 6 5 4 3 2 1
    9 8 7 6 5 4 3 2
    9 8 7 6 5 4 3
    9 8 7 6 5 4
    9 8 7 6 5
    9 8 7 6
    9 8 7
    9 8
    9
*/

#include<stdio.h>
#include<stdlib.h>

int main (){
    int vetor[10]={9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, i, j;

    for(i=10;i>0;i--){
        for(j=0;j<i;j++){
            printf(" %d ", vetor[j]);
        }
        printf("\n");
    }


    printf("\n\n");
    system("pause");
    return 0;
}