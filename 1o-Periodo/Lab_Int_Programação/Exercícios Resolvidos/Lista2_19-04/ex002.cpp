/* Crie um sistema que crie que receba um número e imprima a
imagem a seguir. Caso o usuário digite 5:
xoxox
oxoxo
xoxox
oxoxo
xoxox
 */

#include<stdlib.h>
#include<stdio.h>

void imagem(int x) {
    int i, j, k;

    for(i=0;i<x;i++){
        printf("\n\t");
        if(i%2==0){
            for(j=0;j<x/2;j++){
                for(k=0;k<1;k++){
                    printf("x");
                }
                for(k=0;k<1;k++){
                    printf("o");
                }
            }
            if(x%2==1){
                printf("x");
            }
        }
        else{
            for(j=0;j<x/2;j++){
                for(k=0;k<1;k++){
                    printf("o");
                }
                for(k=0;k<1;k++){
                    printf("x");
                }
            }
            if(x%2==1){
                printf("o");
            }
        }
    }
}

int main() { 
    int num;

    printf("Digite um numero: ");
    scanf("%d", &num);

    imagem(num);

    printf("\n\n");
    system("pause");
    return 0;
}