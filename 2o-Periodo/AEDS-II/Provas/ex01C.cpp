/*
    Dado um valor inicial “n”, fornecido pelo usuário, calcule o valor da série.
    Ex. n=6;
    S=1*(1/1) + 2*(1/2) + 3*(1/3) + 4*(1/4) + 5*(1/5) + 6*(1/6) + n*(1/n)
*/

#include <stdlib.h>
#include <stdio.h>

float calculoN (float n){
    if(n == 0) return 0;
    printf("\n%.2f %.2f", n, n*(1/n));
    return n*(1/n) + calculoN(n-1);
}

int main() {
    int n;
    
    printf("Digite o numero para o calculo: ");
    scanf("%d", &n);

    printf("\nResultado: %f\n\n", calculoN(n));

    system("pause");
    return 0;
}