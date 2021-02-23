/*
    Criar um algoritmo que carregue uma matriz 12 x 4 com os valores das vendas de uma loja,
em que cada linha represente um mês do ano, e cada coluna, uma semana do mês. Para fins
de simplificação considere que cada mês possui somente 4 semanas. Calcule e imprima: -
Total vendido em cada mês do ano;
Total vendido no ano. Qual a melhor semana para vender carros? 1ª, 2ª, 3ª ou 4ª?
*/

#include<stdio.h>
#include<stdlib.h>

// Função para somar toda a matriz (ano)
int somaAno(int x[12][4]){
    int soma = 0, i, j;
    for(int i=0; i<12; i++){
        for(int j=0; j<4; j++){
            soma += x[i][j];
        }
    }
    return soma;
}

// Função para somar cada linha(mes) e armazena no vetor
void somaMes(int x[12][4], int somaMes[12]){
    int i, j;
    for(int i=0; i<12; i++){
        somaMes[i] = 0;
        for(int j=0; j<4; j++){
            somaMes[i] += x[i][j];
        }
    }
}

/* Função para verificar qual foi a melhor semana de vendas

Quando a maior semana de vendas do mês é encontrada,(variável semana), a variável 'aux'
armazena essa posição, que é a semana desse mês. Logo em seguida essa posição é somada
em outra variável 'melhorSem' que é feita para calcular a média no final do código*/

int melhorSemana(int x[12][4]){
    int semana, i, j, aux, melhorSem = 0;
    for(i=0; i<12; i++){
        semana = x[i][0];
        for(j=0; j<4; j++){
            if(semana <= x[i][j]){
                semana = x[i][j];
                aux = j+1;
            }
        }
        melhorSem += aux;
    }
    
    return melhorSem/12;
}

int main(){
    int i, j, vendas[12][4], vendasMensais[12];

    // Recebe a matriz
    for(i=0; i<12; i++){
        for(j=0; j<4; j++){
            printf("%do mes, %do semana: ", i+1, j+1);
            scanf("%d", &vendas[i][j]);
        }
        printf("\n");
    }
    // Exibe a matriz
    for(i=0; i<12; i++){
        for(j=0; j<4; j++){
            printf(" %d ", vendas[i][j]);
        }
        printf("\n");
    }
    // Modifica o vetor de vendas mensais
    somaMes(vendas, vendasMensais);

    // Apresenta os dados
    printf("\n\tRelatorio anual\n\nVendas de cada mes:");
    for(i=0; i<12; i++) printf("\n%d mes: %d",i+1, vendasMensais[i]);

    printf("\n\nVenda total do ano: %d\n\nA melhor semana de vendas foi a %da\n\n", somaAno(vendas), melhorSemana(vendas));

    system("pause");
    return 0;
}
