/*
    Fazer uma função que receba um número inteiro e retorne 1 caso seja par e 0 caso
seja impar.
*/

#include<stdio.h>
#include<stdlib.h>
// Função para verificar se o numero é par ou impar
int ParImpar(int x){
    if(x%2 == 0) return 1;
    return 0;
}

int main(){
    int num;

    printf("Digite um numero: ");
    scanf("%d", &num);

    printf("O numero %d e: ", num);
    printf(ParImpar(num)?"Par":"Impar");

    printf("\n\n");
    system("pause");
    return 0;
}