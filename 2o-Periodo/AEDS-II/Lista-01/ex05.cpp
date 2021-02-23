/*
    Elabore um programa que contenha uma função que permita passar por 
    parâmetro dois números inteiros A e B. A função deve calcular a soma 
    entre estes dois números e armazenar o resultado na variável. A e a multiplicação
    de entre eles na variável B. O resultado deve ser impresso na função principal. 
    Vale ressaltar que essa função não deve retornar nenhum valor.
*/

#include<stdlib.h>
#include<stdio.h>

void changeValue(int *A, int *B){
    *A += *B;
    *B *= (*A - *B);
}

int main(){
    int A, B;

    printf("Digite o valor de A: ");
    scanf("%d", &A);
    printf("Digite o valor de B: ");
    scanf("%d", &B);

    changeValue(&A, &B);

    printf("A + B = %d\nA x B = %d\n\n", A, B);

    system("pause");
    return 0; 
}