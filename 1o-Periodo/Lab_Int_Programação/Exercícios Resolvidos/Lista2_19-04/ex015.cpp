/*
    Anteriormente fizemos a série de fibonacci. Faça o mesmo exercício novamente, porém, utilizando vetores. O tamanho da série será dada pelo usuário.
*/

#include<stdio.h>
#include<stdlib.h>

int main () {
    int size, i;
    printf("Digite o tamanho da serie: ");
    scanf("%d", &size);

    int num[size];

    printf("\n%d, %d", num[0]=0, num[1]=1);
    for(i=2;i<size;i++){
        num[i] = num[i-1] + num[i-2];
        printf(", %d", num[i]);
    }

    printf("\n\n");
    system("pause");
    return 0;
}