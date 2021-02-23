/*
     Faça um Programa que leia três números e mostre em ordem crescente
*/

#include<stdio.h>
#include<stdlib.h>

int main (){
    int num1, num2, num3, maior, menor, medio;

    printf("Digite um numero: ");
    scanf("%i", &num1);
    
    printf("Digite um numero: ");
    scanf("%i", &num2);
    
    printf("Digite um numero: ");
    scanf("%i", &num3);

    maior = num1; // Coloca o num1 como maior

    if(num2 > maior){ // Verifica se o num2 é o maior
        maior = num2;
        if (num1 > num3){ //verica quem é o médio e o menor
            medio = num1;
            menor = num3;
        }   

        else{
            medio = num3;
            menor = num1;
        }
    }

    else if (num3 > maior){ // verifica se o num3 é o maior
        maior = num3;
        if (num2 > num1){ // verifica quem é o médio e o menor
            medio = num2;
            menor = num1;
        }

        else {
            medio = num1;
            menor = num2;
        }
    }

    else { // Verifica quem é o médio e o menor, já que o num1 é o maior.
        if (num2 > num3){
            medio = num2;
            menor = num3;
        }

        else{
            medio = num3;
            menor = num2;
        }
    }

    printf("%i, %i, %i", menor, medio, maior);


    printf("\n\n");
    system("pause");
    return 0;
}
