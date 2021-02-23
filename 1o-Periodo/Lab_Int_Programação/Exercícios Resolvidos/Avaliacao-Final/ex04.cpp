/*
    Valor: 5 pontos. Faça uma função que verifique se um número inteiro é perfeito ou não.
Um valor é dito perfeito quando ele é igual a soma dos seus divisores excetuando ele próprio. (Ex: 6 é perfeito, 6 = 1 + 2 + 3, que são seus divisores). A função deve
retornar um valor booleano.

*/

#include<stdlib.h>
#include<stdio.h>

bool isPerfeito(int n){
    int divs = 0;
    for(int i=1; i<n; i++){
        if(n%i==0) divs += i; 
    }
    if(divs==n)return true;
    return false;
}

int main(){
    int num;
    printf("Digite um numero: ");
    scanf("%d", &num);

    printf("O numero %d ", num);
    printf(isPerfeito(num)?"e um perfeito":"nao e perfeito");

    printf("\n\n");
    system("pause");
}