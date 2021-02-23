/*
    Faça uma função que recebe por parâmetro o raio de uma esfera e calcula o seu
volume (v = (4 * 3,14 * R³)/3).
*/

#include<stdio.h>
#include<stdlib.h>
#include<math.h>

// Calcula o volume
float getVolume(float raio){
    float volume;
    // Retorna o resultado da equação
    return volume = (4*3.14*(pow(raio,3)))/3;
}

int main(){
    float raio;

    printf("Digite o valor do raio: ");
    scanf("%f", &raio);
    // Chama a função e mostra o resultado
    printf("\nO volume da esfera de raio %.2f e: %.2f\n\n", raio, getVolume(raio));

    system("pause");
    return 0;
}