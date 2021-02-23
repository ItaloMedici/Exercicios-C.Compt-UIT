/*
    Faça um programa que receba infinitos números do usuário. O sistema só deve parar de receber números caso o usuário digite um número primo ou um número negativo. Ao final, imprimir quantos números o usuário digitou.

*/

#include<stdlib.h>
#include<stdio.h>

main () {
    int num, primo, i;
    bool sair=true;

    do{
        num = 0;
        primo = 0;
        printf("Digite um numero: ");
        scanf("%d", &num);
        // Verifica se o numero é primo
        for(i=1;i<num+1;i++){
            if(num%i==0){
                primo++;
            }
        }
        // Verifica o numero é primo ou negativo separadamente, pois o while continua enquanto o comando for verdadeiro, usando o condicional ou, o processo nunca iria acabar.
        if(primo == 2 || num<0){
            sair = false;
        }

    } while(sair);
    
    printf("\nO Numero: %d \202 ", num);
    printf(num>0?"primo":"negativo");

    system("Pause>null");
}