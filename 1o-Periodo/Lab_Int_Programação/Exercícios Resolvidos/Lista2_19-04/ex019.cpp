/*
    Escreva um algoritmo que leia um vetor de 20 posições e mostre-o. Em seguida, troque o primeiro elemento pelo o último, o segundo com o penúltimo, o terceiro com o antepenúltimo e, assim, sucessivamente. Mostre o novo vetor após todas as trocas.
*/

#include<stdio.h>
#include<stdlib.h>

int main(){
    int num[20], i, num2[20];

    //recebe os valores
    for(i=0;i<20;i++){
        printf("Digite o %do numero: ", i+1);
        scanf("%d", &num[i]);
    }

    printf("\n");
    // Mostra o vetor
    for(i=0;i<20;i++){
        printf("%do : %d\n", i+1, num[i]);
    }

    // Mostra o vetor invertido
    printf("\n\tINVERSO: \n");
    for(i=20;i>0;i--){
        printf("%do: %d\n", 21-i, num[i-1]);
    }

    printf("\n\n");
    system("pause");
    return 0;
}