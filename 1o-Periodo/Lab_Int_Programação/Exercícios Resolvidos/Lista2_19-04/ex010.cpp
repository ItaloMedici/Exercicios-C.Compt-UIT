/* 
    Faça um programa parecido com o anterior, mas agora para imprimir a letra E. Obs.: todos as chamadas da função printf deverão estar dentro do laço for, com exceção dos “\n” finais. Para fazer impressões diferentes em cada iteração, utilize comandos condicionais (if) dentro do laço for.
    Exemplo de saída:
        EEEEEEEEEE
        EEE
        EEE
        EEE
        EEE
        EEE
        EEEEEEEEEE
        EEE
        EEE
        EEE
        EEE
        EEE
        EEE
        EEE
        EEE
        EEE
        EEEEEEEEEE 
*/

#include<Stdlib.h>
#include<stdio.h>

int main () {
    int i;

    for(i=0;i<14;i++){
        if(i == 0){ 
            printf("EEEEEEEEEE\n");
        }
        printf("EEE\n");
        if(i == 4){
            printf("EEEEEEEEEE\n");
        }
        if(i == 13){
            printf("EEEEEEEEEE\n");
        }
    }

    printf("\n\n");
    system("pause");
    return 0;    
}