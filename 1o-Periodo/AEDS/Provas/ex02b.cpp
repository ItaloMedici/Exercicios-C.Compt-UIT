
#include <stdlib.h>
#include <stdio.h>

struct supermercado {
    float preco = 2.30;
    char nome[20] = "Bolacha";
}; 

int main() {
    struct supermercado Produtos;
    supermercado *prateleiraA = &Produtos;

    printf("Produto: %s\nValor: R$%.2f\n\n", (*prateleiraA).nome, (*prateleiraA).preco);

    system("pause");
    return 0;
}