/*
    Faça um programa em C que imprima as letras do alfabeto, produzindo a seguinte saída:
        Letras maiusculas:
        A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
        Letras minusculas:
        a b c d e f g h i j k l m n o p q r s t u v w x y z
    No entanto, você deve imprimir caractere por caractere, começando com a letra ‘A’ e depois um laço fará o resto, ou seja, a cada iteração você deverá incrementar o caractere, de tal forma a imprimir o ‘B’, depois o ‘C’, etc. Depois você deverá fazer outro laço com o mesmo raciocínio para imprimir as letras minúsculas. Dica: você pode incrementar o valor de uma variável char.
*/

#include<stdlib.h>
#include<stdio.h>
#include<string.h>
#include <ctype.h>

int main () {
    char alfabeto[26]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','y','x','z'};
    int i;

    printf("Letras Maiusculas: \n");
    for(i=0;i<26;i++){
        printf("%c, ",toupper(alfabeto[i]));
    }
    printf("\n\nLetras Minusculas: \n");
    for(i=0;i<26;i++){
        printf("%c, ", alfabeto[i]);
    }


    printf("\n\n");
    system("Pause");
    return 0;
}