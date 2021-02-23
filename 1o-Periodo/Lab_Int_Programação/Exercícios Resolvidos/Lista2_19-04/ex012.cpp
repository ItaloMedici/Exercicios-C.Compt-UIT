/*
    Faça um programa em C que imprima quais os números de 1 a 100 são divisíveis por 3 ou por
7.
*/

#include<stdio.h>
#include<stdlib.h>

int main () {
    int i;

    //laço para 100 contagens
    for(i=1;i<100;i++){
        // Verifica se o i é divisivel por 7 ou 3
        if(i%3 == 0 || i%7 == 0){
            if (i%3==0 && i%7 == 0){
                printf("%i e divisivel por 3 e por 7", i);
            }

            else if(i%3==0){
                printf("%i e divisivel por 3", i);
            }

            else {
                printf("%i e divisivel por 7", i);
            }
        }

        else{
            printf("%i nao e divisivel 3 nem por 7", i);
        }

        printf("\n");
    }

    printf("\n\n");
    system("pause");
    return 0;
}