/*
     Escreva um programa que receba um número inteiro não-negativo n e imprima os n primeiros números primos.
*/

#include<stdlib.h>
#include<stdio.h>

bool isPrimo(int n){
    int aux = 0;
    for(int i=n; i>0; i--){
        if(n%i==0) aux++;
    }
    if(aux == 2) return true;
    return false;
}

int main(){
    int tamanho, i;
    printf("Digite a quantidade de numeros: ");
    scanf("%d", &tamanho);

    int n[tamanho];

    for(int i=0; i<tamanho; i++){
        do{
            printf("%d numero: ", i+1);
            scanf("%d", &n[i]);
        }while(n[i] < 0);
    }

    for(int i=0; i<tamanho; i++){
        printf("\nO numero %d ", n[i]);
        printf(isPrimo(n[i])?"e primo":"nao e primo");
    }

    printf("\n\n");
    system("pause");
    return 0;
}