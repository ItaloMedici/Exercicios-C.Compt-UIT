/*
    Fazer uma função que receba um número inteiro e retorne o fatorial.
*/

#include<stdio.h>
#include<stdlib.h>

int fatorial(int num){
    int fatorial=1;
    for(int i=num; i>0; i--){
        fatorial *= i;
    }

    return fatorial;
}

int main(){
    int num;
    
    printf("Digite um numero: ");
    scanf("%d", &num);

    printf("%d! = %d", num, fatorial(num));

    printf("\n\n");
    system("pause");
    return 0;
}