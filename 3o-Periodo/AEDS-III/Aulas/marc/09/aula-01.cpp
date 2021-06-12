#include<stdlib.h>
#include<stdio.h>

#define TAM 7

int main(void){
    int *vetor01 = (int*) malloc(sizeof(int)*TAM);
    printf("%p\n", vetor01);

    for(int i = 0; i<TAM; i++){
        vetor01[i] = i;
        printf("%p \t%d\n", &vetor01[i], vetor01[i]);
    }

    free(vetor01);
    vetor01 = NULL;
}