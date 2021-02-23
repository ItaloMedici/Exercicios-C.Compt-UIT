/*
    Escreva um procedimento (procedimento é uma função do tipo void) que recebe as
3 notas de um aluno e imprima se ele está aprovado, reprovado ou em exame
especial (menor que 40 é reprovado, entre 40 e 59 é exame especial e maior que
60 aprovado).
*/

#include<stdlib.h>
#include<stdio.h>

void resultados(int notas[3]){
    int soma = 0;
    for(int i=0; i<3; i++) soma += notas[i];

    printf("\nResultado: ");
    // Verifica as condições e mostra o resultado
    if(soma < 40) printf("Reprovado");
    else if(soma < 60) printf("Exame especial");
    else printf("Aprovado");

    printf("\n\n");
    system("pause");
}

int main(){
    int notas[3], i;

    for(i=0; i<3; i++){
        printf("Digite a %da nota: ", i+1);
        scanf("%d", &notas[i]);
    }

    resultados(notas);

    return 0;
}