/*
    Faça um Programa que peça os 3 lados de um triângulo. O programa deverá informar se os valores podem ser um triângulo. Indique, caso os lados formem um triângulo, se o mesmo é: equilátero, isósceles ou escaleno.
    - Dicas:
    - Três lados formam um triângulo quando a soma de quaisquer dois lados for maior que o terceiro;
    - Triângulo Equilátero: três lados iguais;
    - Triângulo Isósceles: quaisquer dois lados iguais;
    - Triângulo Escaleno: três lados diferentes;
*/

#include<stdio.h>
#include<stdlib.h>

int main (){
    int A, B, C;

    printf("Digite o lado A: ");
    scanf("%i", &A);
    printf("Digite o lado B: ");
    scanf("%i", &B);
    printf("Digite o lado C: ");
    scanf("%i", &C);
    printf("\n");

    if(A + B > C && A + B > B && B + C > A){ //verifica se é um triângulo
        if(A == B && A == C){ // Verifica se é equilatero
            printf("Triangulo Equilatero");
        }
        else if(A != B && A != B && B != C){ //verifica se é esclaeno
            printf("Triangulo Escaleno");
        }

        else { //triângulo escaleno
            printf("Triangulo Isoseles");
        }
    }

    else{
        printf("Nao e um triangulo");
    }

    printf("\n\n");
    system("pause");
    return 0;
}