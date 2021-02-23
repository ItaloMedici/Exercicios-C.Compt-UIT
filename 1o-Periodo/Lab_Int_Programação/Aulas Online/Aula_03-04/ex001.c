#include<stdio.h>
#include<stdlib.h>

int main (){
    float valor;
    int resp = 0;

    printf("Digite o valor da compra");
    scanf("%f", &valor);

    printf("\nA vista [1]\nA prazo [2]\nR.: ");
    scanf("%i", &resp);

    if (resp == 1){
        if (valor <= 100){
            valor = valor*0.97;
            printf("Valor total: %2.f",valor);
        }

        else if (valor <= 150){
            valor = valor*0.95;
            printf("Valor total: %2.f", valor);
        }

        else if (valor <= 300){
            valor = valor*0.9;
            printf("Valor total: %2.f", valor);
        }

        else if (valor < 300){
            valor = valor*0.85;
            printf("Valor total: %2.f", valor);
        }
    }
    else {
        printf("Valor total: %2.f", valor);
    }

    system("pause");
    return 0;
}
