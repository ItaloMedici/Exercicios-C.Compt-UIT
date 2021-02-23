/*
    Nestes dias frios você foi solicitado para catalogar as temperaturas da última semana na
cidade de Itaúna. Crie uma matriz de float 24x7 que represente hora do dia e o dia da semana. Peça
ao usuário para preencher esta matriz, solicitando a temperatura naquele dia e horário. Ao final
exiba os dias e horários em que a temperatura foi mais quente e mais fria na semana.
*/

#include<stdlib.h>
#include<stdio.h>

void getQuenteFrio(float x[24][7], int y[2], int z[2]){
    float menor = x[0][0], maior = x[0][0];

    for(int i=0; i<24; i++){
        for(int j=0; j<7; j++){

            if(x[i][j] > maior){
                maior = x[i][j];
                y[0] = i+1;
                y[1] = j+1;
            }

            if(x[i][j] < menor){
                menor = x[i][j];
                z[0] = i+1;
                z[1] = j+1;
            }
        }
    }
}

int main(){
    float temps[24][7];
    int i, j, frio[2], quente[2];

    for(i=0; i<7; i++){
        printf("\tDia %d: \n", i+1);
        for(j=0; j<24; j++){
            printf("Temperatura das %dh: ", j+1);
            scanf("%f", &temps[j][i]);
        }
        printf("\n");
    }

    for(int i=0; i<24; i++){
        for(int j=0; j<7; j++){
            printf(" %.2f ", temps[i][j]);
        }
        printf("\n");
    }

    getQuenteFrio(temps, quente, frio);

    printf("\nO dia mais frio foi no %do dia as %dh", frio[1], frio[0]);
    printf("\nO dia mais quente foi no %do dia as %dh", quente[1], quente[0]);
    
    printf("\n\n");
    system("pause");
    return 0;
}
