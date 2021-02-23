/*
    Faça um programa que calcule as raízes de uma equação do segundo grau, na forma ax2 + bx + c. O programa deverá pedir os valores de a, b e c e fazer as consistências, informando ao usuário nas seguintes situações:
    a - Se o usuário informar o valor de A igual a zero, a equação não é do segundo grau e o programa não deve fazer pedir os demais valores, sendo encerrado;
    b - Se o delta calculado for negativo, a equação não possui raizes reais. Informe ao usuário e encerre o programa;
    c - Se o delta calculado for igual a zero a equação possui apenas uma raiz real informe-a ao usuário;
    d - Se o delta for positivo, a equação possui duas raiz reais; informe-as ao usuário;

*/

#include<stdlib.h>
#include<stdio.h>
#include<math.h>

int main() {
    int a, b, c, delta = 0;
    float x1, x2;

    printf("Digite o valor de a: ");
    scanf("%i", &a);

    if(a == 0){ // Verifica se o valor de a é igual a 0, finalizando o programa se for verdadeiro
        printf("Equacao nao e do 2o grau\n\n");
        system("pause");
        exit(0);
    }

    printf("Digite o valor de b: ");
    scanf("%i", &b);

    printf("Digite o valor de c: ");
    scanf("%i", &c);

    delta = pow(b, 2) - (4*a*c); // Calcula o valor de delta.

    system("cls"); //Limpa a tela do prompt (windows).
    printf("a: %i\nb: %i\nc: %i\nDelta: %i", a, b, c, delta); // Mostra ao usuário todos valores.


    if (delta < 0) { // Verifica se o delta é negativo.
        printf("\nEquacao nao possui raizes reais.\n\n");
        system("pause");
        exit(0);
    }

    x1 = (-b + sqrt(delta))/2*a; //Calcula a primeira raíz.
    x2 =  (-b - sqrt(delta))/2*a; //Calcula a segunda raíz.

    printf("\nRaiz 1: %2.f", x1);

    if (x2 != x1){ //Verifica se as raízes são diferentes.
        printf("\nRaiz 2: %2.f", x2);
        printf("\n\nEquacao possui duas raizes reais.");
    }

    else{
        printf("\n\nEquacao possui apenas uma raiz real.");
    }

    printf("\n\n");
    system("pause");
    return 0;
}