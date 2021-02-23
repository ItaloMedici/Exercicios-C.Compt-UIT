/*
    O saudoso apresentador Gugu Liberato fazia uma brincadeira entre casais em seu programa Domingo Legal. Os casais eram separados e respondiam a questões iguais, ao final era analisado quantas respostas iguais eles responderam. As perguntas eram de Verdadeiro e Falso. Faça um programa que receba e armazene em vetores 5 respostas (V ou F) do Marido e 5 da mulher, ao final verifique quantas respostas iguais eles responderam.
*/

#include<stdlib.h>
#include<stdio.h>
#include<ctype.h>

int main(){
    int i, cont_acertos=0;
    char marido[5], mulher[5];

    printf("\tVez do marido\n");
    for(i=0;i<5;i++){
        toupper(printf("Digite a %do resposta: ", i+1));
        scanf(" %c", &marido[i]);
    }

    printf("\tVez da Esposa\n");
    for(i=0;i<5;i++){
        toupper(printf("Digite a %do resposta: ", i+1));
        scanf(" %c", &mulher[i]);
    }

    for(i=0;i<5;i++){
        if(marido[i]==mulher[i]){
            cont_acertos++;
        }
    }

    printf("Total de acetos: %d", cont_acertos);

    printf("\n\n");
    system("pause");
    return 0;
}