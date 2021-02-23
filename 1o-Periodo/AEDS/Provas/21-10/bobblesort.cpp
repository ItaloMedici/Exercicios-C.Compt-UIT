#include <stdio.h>
#include <stdlib.h>

// Ordenação bolha recursiva
void bolha_recursiva (int n, int *v){
    int j, troca = 0;;
    for (j=0; j<n-1; j++)
        if (v[j]>v[j+1]) {
            int temp = v[j];
            v[j] = v[j+1];
            v[j+1] = temp;
            troca = 1;
        }
    if (troca != 0)  
        bolha_recursiva(n-1,v);
}
int main (void) {
    int i;
    int v[8] = {25,48,37,12,57,86,33,92};
    bolha_recursiva(8,v);

    printf("Vetor ordenado: ");

    for (i=0; i<8; i++){
        printf("%d ",v[i]);
    } 
    return 0;
}