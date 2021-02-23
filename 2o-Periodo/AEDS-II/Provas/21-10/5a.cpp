#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct pessoa{
    char nome[30], endereco[30];
    int idade;
}pessoa[5];

int main (void){
    FILE *file;
    file = fopen("struct.txt","wb");
    if(file == NULL){
        printf("Erro");
        system("pause");
        exit(1);
    }
    int i;
    for(i=0;i<5;i++){
        printf("\n\nPessoa %i",i);
        scanf("%s",&pessoa[i].nome);
        scanf("%s",&pessoa[i].endereco);
        scanf("%i",&pessoa[i].idade);
    }
    fwrite(&pessoa,sizeof(struct pessoa),5,file);
    fclose(file);
    system("pause");
}