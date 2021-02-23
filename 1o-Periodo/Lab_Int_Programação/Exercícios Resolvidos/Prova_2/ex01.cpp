/*
     Continuação do exercício iniciado em sala. Fazer um programa que receba do usuário o
    tamanho do vetor de números reais. Receber os valores do usuário. O programa deverá inverter o vetor através de um função void (procedimento). Não é permitido utilizar um vetor auxiliar na função.
*/

#include<stdlib.h>
#include<stdio.h>

void inverterVet(int x[], int tam){
    for(int i=0; i<tam; i++){
        printf(" %d ", x[(tam-1) -i]);
    }
}

int main(){
    int tamanhoVet, i;

    printf("Digite o tamanho do vetor: ");
    scanf("%d", &tamanhoVet);

    int vet[tamanhoVet];
    
    for(i=0; i<tamanhoVet; i++){
        printf("Preencha %d casa do vetor: ", i+1);
        scanf("%d", &vet[i]);
    }

    inverterVet(vet, tamanhoVet);

    printf("\n\n");
    system("pause");
    return 0;
}