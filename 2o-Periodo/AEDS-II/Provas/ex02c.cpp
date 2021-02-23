/*
    Faça um programa em C para receber um vetor de número inteiros. Apresente a soma, o maior
    número digitado. Implemente ponteiro e função.
*/

#include <stdio.h>
#include <stdlib.h>

int maiorVet(int *vet, int n){
    int maior = *(vet + 0);
    for(int i=0; i<n; i++){
        if(*(vet + i) > maior) maior = *(vet + i);
    }
    return maior;
}

int somaVet(int vet[], int n) {
    int soma = 0;
    for(int i=0; i<n; i++){
        soma += *(vet + i);
    }
    return soma;
}

int main() {
    int size;

    printf("Digite o tamanho do vetor: ");
    scanf("%d", &size);

    int vet[size];

    for(int i=0; i<size; i++){
        printf("Digte o %do numero: ", i+1);
        scanf("%d", &vet[i]);
    }

    printf("\nO maior numero do vetor e: %d\nA soma de todo vetor e: %d\n\n", maiorVet(vet, size), somaVet(vet, size));

    system("Pause");
    return 0;
}
