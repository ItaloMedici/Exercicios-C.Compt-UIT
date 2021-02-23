/*
    Escreva uma função que receba como parâmetro uma matriz quadrada
de ordem n de inteiros e devolve verdadeiro se ela é uma matriz triangular superior, ou falso, caso contrário. Matriz
triangular superior é uma matriz onde todos os elementos de posições acima da diagonal
principal são diferentes de 0 e todos os elementos demais elementos são iguais a 0.
*/

#include<stdio.h>
#include<stdlib.h>


bool isTriangSup(int *mat, int n){
    int aux1 = 0, aux2 = 0;
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            if(i<j && (*(mat + (i * n) + j) != 0)) aux1++;
            else if(*(mat + (i * n) + j) == 0) aux2++;
        }
    }
    if(aux1 == n && n*n-aux1==aux2) return true;
    return false;
}

int main(){
    int n;

    printf("Digite a ordem da matriz: ");
    scanf("%d", &n);

    int mtz[n][n];

    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            printf("Preencha %d linha %d coluna: ", i+1, j+1);
            scanf("%d", &mtz[i][j]);
        }
        printf("\n");
    }

    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            printf(" %d ", mtz[i][j]);
        }
        printf("\n");
    }

    printf(isTriangSup(*mtz, n)?"e triangulo superior":"Nao e");

    printf("\n\n");
    system("pause");
}