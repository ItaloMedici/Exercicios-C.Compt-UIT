#include<stdlib.h>
#include<stdio.h>

void getOddList(int size, double list[], double oddsList[]){
    int countNums = 0;
    int auxI = 0;
    int auxJ = 0;
        
    for(int i=0; i<size; i++){
        auxI = list[i];

        for(int j=0; j<size; j++){
            auxJ = list[j];

            if(auxI == auxJ){
                countNums++;
            }
        }
        //Se for par eu adiciono o numero na lista de impares, se não eu coloco um numero negativo
        if(countNums%2 == 1) oddsList[i] = list[i];
        else oddsList[i] = -1;
        printf("-----> %d, %d, %d\n", oddsList[i], list[i], countNums);

        countNums = 0;
    }
}

void printOdds(double list[], int size){
    for(int i=0; i<size; i++){
        if(list[i] > 0) printf("\t%i\n", list[i]);
    }
}


int main(void){
    int sizeList = 2;
    double list[sizeList] = {1,2};
    double oddsList[sizeList];
    
    getOddList(sizeList, list, oddsList);
    printOdds(oddsList, sizeList);

    system("PAUSE");
    return 0;
}

/* 
#include<stdlib.h>
#include<stdio.h>

void getOddList(int size, double list[], double oddsList[]){
    int countNums = 0;
    int auxI = 0;
    int auxJ = 0;
        
    for(int i=0; i<size; i++){
        auxI = list[i];

        for(int j=0; j<size; j++){
            auxJ = list[j];

            if(auxI == auxJ){
                countNums++;
            }
        }
        //Se for par eu adiciono o numero na lista de impares, se não eu coloco um numero negativo
        if(countNums%2 == 1) oddsList[i] = list[i];
        else oddsList[i] = -1;

        countNums = 0;
    }
}

void printOdds(double list[], int size){
    for(int i=0; i<size; i++){
        if(list[i] > 0) printf("\t%i\n", list[i]);
    }
}


int main(void){
    int sizeList = -1;

    do{
        printf("Quantas casas serão a lista: ");
        scanf("%d", &sizeList);

        double list[sizeList];
        double oddsList[sizeList];
        
        for(int i=0; i<sizeList; i++){
            do{
                printf("Digite o %io numero: ", i+1);
                scanf("%i", &list[i]);
            } while(list[i] < 0);
        }
        
        getOddList(sizeList, list, oddsList);
        printOdds(oddsList, sizeList);

    } while(sizeList != 0);
    

    system("PAUSE");
    return 0;
}
 */