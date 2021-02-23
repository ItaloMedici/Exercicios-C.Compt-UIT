/*
    Agora faça um programa que irá simular sua aprovação na UIT, o usuário deverá entrar com 3 notas, sendo que as duas primeiras devem ser menor que 30 e a última menor que 40. O usuário deverá entrar também com o percentual de faltas. Como vocês sabem o aluno só é aprovado se tiver frequencia maior que 75 e nota maior que 60. Nota entre 40 e 60 é recuperação Frequencia abaixo de 75 e nota abaixo de 40 já é reprovação direto
*/

#include<stdlib.h>
#include<stdio.h>

int main(){
    float nota1 = 31, nota2 = 31, nota3 = 41, frequencia = 101, total;
 
    //laço para não fugir do máximo exigido
    while (nota1 > 30 || nota2 > 30 || nota3 > 40 || frequencia > 100) {
        printf("Digite sua 1o nota (max. 30): ");
        scanf("%f", &nota1);

        printf("Digite sua 2o nota (max. 30): ");
        scanf("%f", &nota2);

        printf("Digite sua 3o nota (max. 40): ");
        scanf("%f", &nota3);

        printf("Digite sua frequencia (max. 100%): ");
        scanf("%f", &frequencia);

        printf("\n");
    }

    total = nota1 + nota2 + nota3; //soma o total das notas

    //Se a frequencia for menor que 75 ou a nota for menor que 40 é reprovado, finalizando o programa
    if (frequencia < 75 || total < 40){ 
        printf("Reprovado");

        printf("\n\n");
        system("pause");
        exit(0);
    }
    
    else if(total >= 40 && total < 60){ //Verifica se a nota esta entre 40 e 60
        printf("Recuperação");
    }

    else{ // Nota maior que 60
        printf("Aprovado!");
    }
    
    printf("\n\n");
    system("pause");
    return 0;     
}