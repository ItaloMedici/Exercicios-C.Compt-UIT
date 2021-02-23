/*
    Valor: 5 pontos. Escreva uma função que receba como parâmetro uma lista de tamanho fixo 10 contendo apenas valores 0 e 1 e que imprima as posições inicial e final da maior seqüência S de elementos 0 dentro da lista. Ex: Lista={0,1,1,0,0,0,1,0,0,1} pini = 4 e pfim = 6 S={0,0,0} Obs: No caso de empate em tamanho, a primeira ocorrência de S é a que deve ser retornada.
*/

#include<stdio.h>
#include<stdlib.h>

void listaS(int lista[10]){
    int pini=0, pfim=0, cont=0, max=0, i=0;

    for(i=0; i<10 ; i++){
        if(lista[i] == 0){
            cont++;
        }
        else{
            if(max<cont){
                max=cont;
                pini = i-max+1;
                pfim = i;
            }
            
            cont = 0;
        }
    }
    
    if(max<cont){
        max=cont;
        pini = i-max;
        pfim = i-1;
    }

    printf("\nPonto Inicial %d, ponto final %d\n\n", pini, pfim);
}

int main(){
    
    int lista[10];
    for(int i=0; i<10; i++){
        do{
            printf("Digite o %d numero: ", i+1);
            scanf("%d", &lista[i]);
        }while(lista[i] != 1 && lista[i] != 0);
    }

    listaS(lista);

    system("pause");
    return 0;
}