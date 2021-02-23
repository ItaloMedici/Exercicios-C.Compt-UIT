#include<stdlib.h>
#include<stdio.h>

void insertionSort(int *vet, int tamanho){
    int aux;
    for(int i=0; i<tamanho; i++){
        for(int j=i+1; j>0; j--){
            if(vet[j] < vet[j-1]){
                aux = vet[j];
                vet[j] = vet[j-1];
                vet[j-1] = aux;
            }   
            else break;
        }
    }
}

int main() {
    int vet[5] = {27, 2, 15, 7, 8};

    insertionSort(vet, 5);

    for(int i=0; i<5; i++){
        printf(" %d ", vet[i]);
    }

    printf("\n\n");
    system("pause");
    return 0;
}