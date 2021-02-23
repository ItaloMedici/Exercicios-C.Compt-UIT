/*
    Faça um programa que escreva a música da xuxa utilizando laço de repetião
*/

#include<stdlib.h>
#include<stdio.h>
#include<locale.h>

int main() {
    setlocale(LC_ALL, "Portuguese"); 
    int i;

    // Laço para exibir o texto 5 vezes até 0
    for(i=5;i>0;i--){
        printf("%d patinhos foram passear além das montanhas para brincar A mamãe gritou Quack quack quack mas só %d patinhos Voltaram de lá \n", i, i-1);
    }

    printf("\n\n");
    system("pause");
    return 0;
}