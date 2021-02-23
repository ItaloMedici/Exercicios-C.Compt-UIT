/*
    Você deverá criar uma função que retorna a data juliana. A data juliana é um valor de 0 a
6 que é obtido atráves do dia, mês e ano de uma data e calculado da seguinte forma:
((1461*(ano+4800+(mes-14)/12))/4+(367*(mes-2-12*((mes-14)/12)))/12- (3*((ano+4900+(mes14)/12)/100))/4+ dia-32075) O valor retornado(0 a 6) corresponde aos seguintes dias da semana: 0 –
segunda-feira, 1 – terça-feira, 2 – quarta-feira, 3 – quinta-feira, 4 – sexta-feira, 5 – sábado, 6 – domingo. Desta forma você deverá receber o nome do usuário e o dia que ele nasceu e retornar, por
exemplo, a seguinte frase: “Fulano, você nasceu em uma segunda-feira!”
*/

#include<stdio.h>
#include<stdlib.h>

int dataJuliana(int mes, int dia, int ano){
    return ((1461*(ano+4800+(mes-14)/12))/4+(367*(mes-2-12*((mes-14)/12)))/12- (3*((ano+4900+(mes-14)/12)/100))/4+ dia-32075)%7;
}

int main(){
    int mes, dia, ano;

    printf("Digite o seu mes de nascimento: ");
    scanf("%d", &mes);
    printf("Dia: ");
    scanf("%d", &dia);
    printf("Ano: ");
    scanf("%d", &ano);

    int data = dataJuliana(mes,dia,ano);

    switch (data)
    {
    case 0:
        printf("Você nasceu em uma segunda-feira!");
        break;
    case 1:
        printf("Você nasceu em uma terca-feira!");
        break;
    case 2:
        printf("Você nasceu em uma quarta-feira!");
        break;
    case 3:
        printf("Você nasceu em uma quinta-feira!");
        break;
    case 4:
        printf("Você nasceu em uma sexta-feira!");
        break;
    case 5:
        printf("Você nasceu em um sabado!");
        break;
    case 6:
        printf("Você nasceu em um domingo!");
        break;   
    default:
        printf("Data invalida");
    }

    printf("\n\n");
    system("pause");
    return 0;
}