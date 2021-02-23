/*
    Devido à pandemia e redução das vendas no comércio, uma loja realizou uma grande promoção e pediu que você criasse um programa para realizar o cálculo das compras dos clientes. O sistema deverá receber valores do tipo float e ir somando até o usuário digitar o valor 0, que significa que acabaram as compras. Com o valor total somado deverá solicitar em quantas parcelas ele irá pagar, também deverá informar se é para entregar ou retirar na loja. Se ele pagar em 1x ele terá 50% de desconto e se parcelar apenas 30%. Se for para entregar tem R$30,00 de frete. Ao final diga o valor de cada parcela com frete incluído.
*/

#include<stdlib.h>
#include<stdio.h>

int main() {
    int parcelas, frete;
    float valor_total=0, valor;

    do{
        printf("Digite  valor dessa compra: ");
        scanf("%f", &valor);

        valor_total += valor;

    }while(valor!=0);

    do{
        printf("Qual a quantidade de parcelas? ");
        scanf("%d", &parcelas);
    }while(parcelas<=0);

    printf("Digite:\n1 - Para retirar na loja\n2 - Entregar (+R$30,00 de frete)\nR: ");
    scanf("%d", &frete);

    if(frete==2){
        valor_total += 30;
    }

    valor_total /= parcelas;

    printf(parcelas>1?"O Valor de cada parcela e: %.2f": "O valor da compra e: %.2f", valor_total);


    printf("\n\n");
    system("pause");
    return 0;
}