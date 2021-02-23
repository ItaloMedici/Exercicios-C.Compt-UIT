/*
    Faça um programa para receber o: o código, quantidade em estoque, peso e valor de uma
    relação de produtos. A quantidade de itens a serem cadastrados será definida pelo usuário. 
    Após cadastrar todos os produtos liste: o código, valor unitário de cada produto e o valor total 
    dos itens informados. Implemente alocação dinâmica de memória e struct.
*/

#include <stdlib.h>
#include <stdio.h>

struct produto {
    int codigo;
    int quantidade;
    float peso;
    float valor;
    float valor_total = 0;
};

int main () {
    int quantidade;
    printf("Digite a quantidade de produtos: ");
    scanf("%d", &quantidade);

    struct produto Produtos[quantidade];

    float *d;
    d = (float *)malloc(sizeof(Produtos[quantidade]));

    for(int i=0; i<quantidade; i++){
        printf("\tProduto %d", i+1);
        printf("\nDigite o codigo: ");
        scanf("%d", &Produtos[i].codigo);
        printf("Digite a quantidade ");
        scanf("%d", &Produtos[i].quantidade);
        printf("Digite o peso ");
        scanf("%f", &Produtos[i].peso);
        printf("Digite o valor ");
        scanf("%f", &Produtos[i].valor);
        printf("\n");
    }

    system("cls");

    for(int i=0; i<quantidade; i++){
        printf("\n\tProduto %d", i+1);
        printf("\nCodigo: %d", Produtos[i].codigo);
        printf("\nQuantidade: %d", Produtos[i].quantidade);
        printf("\nPeso: %.2f", Produtos[i].peso);
        printf("\nValor: R$%.2f", Produtos[i].valor);
        Produtos[i].valor_total = Produtos[i].valor * Produtos[i].quantidade;
        printf("\nValor total: R$%.2f", Produtos[i].valor_total);
    }

    printf("\n\n");
    system("pause");
    return 0;
}   