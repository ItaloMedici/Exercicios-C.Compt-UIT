/*
     Crie um algoritmo que receba a quantidade de turmas do professor e a quantidade de alunos por turmas. Depois o sistema irá receber a nota de cada alunos em cada turma e imprimir na tela.
*/

#include<stdlib.h>
#include<stdio.h>

int main (){
    int tm = 0, al = 0, i, j;

    // Recebe a quantidade de turmas
    printf("Digite a quantidade de turmas: ");
    scanf("%d", &tm);
    
    // Vetor para receber a quantidade de cada aluno por turma, matriz para receber as notas de cada aluno de cada turma.
    int alunos[tm]; 
    float notasTotal[100][100];

    // Laço para receber o numero de cada aluno por turma
    for (i=0;i<tm;i++){
        printf("Digite a quantidade de alunos da tuma %d: ", i+1);
        scanf("%d", &alunos[i]);

    }

    // Laço para correr dentro de cada turma
    for (int t=0;t<tm;t++){
        al = alunos[t];
        printf("\n");
        // Laço para correr dentro de cada aluno e receber sua nota na matriz
        for (int a=0;a<al;a++){
            printf("Digite a nota do %do aluno da turma %d: ", a+1, t+1);
            scanf("%f", &notasTotal[t][a]);
        }
    }

    // Laços para correr dentro da matriz e mostrar a nota de cada aluno.
    for(i=0;i<tm;i++){
        al = alunos[i];
        printf("\n\tNOTAS TURMA %d",i+1);
        for(j=0;j<al;j++){
            printf("\n%do Aluno: %.2f pts", j+1, notasTotal[i][j]);
        }
        printf("\n");
    }

    printf("\n\n");
    system("pause");
    return 0;
}