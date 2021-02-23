/*
    Criar um programa que contenha uma matriz de duas dimentões 5x3 que representam o tempo de 5 atletas em 3 etapas de uma competição. Receba o tempo de cada atleta em cada etapa.
*/

#include<stdlib.h>
#include<stdio.h>

int main(){
    int i, j, camps[5][3]; 

    for(i=0; i<5; i++){
        for(j=0; j<3; j++){
            printf("%d campeao, %d tempo: ", i+1, j+1);
            scanf("%d", &camps[i][j]);
        }
        printf("\n");
    }

    // incompleto....       

}