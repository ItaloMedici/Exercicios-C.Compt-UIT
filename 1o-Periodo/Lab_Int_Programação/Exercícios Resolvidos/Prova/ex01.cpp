/*
    Faça um programa para avaliar se a pessoa pode estar com Corona Vírus. Você deve perguntar se ela está com Febre, se está tossindo e se está com o corpo cansado. Para cada uma destas 3 perguntas o usuário deverá responder 0, 1 ou 2 que significa pouco, médio ou muito. Também deverá perguntar se teve contato com alguém que apresentava sintomas. Se a pessoa responder que teve contato com alguém com sintomas e que a média das 3 outras perguntas for maior ou  igual a 1, você deverá informar "Você pode estar infectado, procure um médido", senão informar "Você provavelmente não está infectado, mas fique em casa e se cuide".
*/

#include<stdio.h>
#include<stdlib.h>

int main(){
    int resp, i;
    float media = 0;

    printf("Responda o Questinatario abaixo da seguinte maneira:\n\t0 - Pouco\n\t1 - Medio\n\t2 - Muito\n\n");
    
    printf("Sente febre?\nR: ");
    scanf("%d", &resp);

    media += resp;

    printf("Esta tossindo?\nR: ");
    scanf("%d", &resp);

    media += resp;

    printf("Sente o corpo cansado?\nR: ");
    scanf("%d", &resp);

    media += resp;

    printf("Teve contato com alguem com sintomas aparente? [1 - sim/2 - Nao]\nR: ");
    scanf("%d", &resp);

    media/=3;

    if(media>1 || resp==1){
        printf("Voce pode estar infectado, procure um medido");
    }

    else{
        printf("Voce provavelmente não está infectado, mas fique em casa e se cuide");
    }

    
    printf("\n\n");
    system("pause");
    return 0;
}
