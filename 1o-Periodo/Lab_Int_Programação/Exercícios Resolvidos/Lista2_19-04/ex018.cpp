/*
    Faça um algoritmo que preencha um vetor como nove números inteiros e mostre quais são primos e suas respectivas posições.
*/

#include <stdio.h>
#include <stdlib.h>

int main () {
    int num[9], i, j, primo=0, posi, nump;

    for(i=0;i<9;i++){
        printf("Digite o %do numero: ", i+1);
        scanf("%d", &num[i]);
    }

    for(i=0;i<9;i++){
        for(j=1;j<num[i]+1;j++){
            if(num[i]%j == 0){
                primo++;
                posi=i+1;
                nump = num[i];
            }
            //printf("%d %% %d = %d /// posi: %d nump: %d primo: %d\n", num[i], j, num[i]%j, posi, nump, primo);
        }
        
        if(primo == 2){
            printf("O numero: %d na casa: %d, \202 primo\n", nump, posi);
        }
        primo = 0;
        posi = 0;
        nump = 0;
    }

    printf("\n\n");
    system("pause");
    return 0;
}