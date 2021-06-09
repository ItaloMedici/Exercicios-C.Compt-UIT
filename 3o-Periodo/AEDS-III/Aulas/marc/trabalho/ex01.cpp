#include<stdlib.h>
#include<stdio.h>
#include<list>
#include<algorithm>

using namespace std;

list<double> addNumList(list<double> list, double num){
    list.push_back(num);
    return list;
}

bool isNumExist(list<double> list, double num){
    std::list<double>::iterator pont;
    
    pont = find(list.begin(), list.end(), num);

    if(num == *pont) return true;
    return false;
}

list<double> getOddList(list<double> oldList, list<double> newList){
    for(auto auxI : oldList){
        int countOdd = 0;

        for(auto auxJ : oldList){
            if(auxJ == auxI){
                countOdd++;
            }
        }

        if(countOdd%2 != 0 && !isNumExist(newList, auxI)){
            newList.push_back(auxI);
        }
    }
    return newList;
}

void printList(list<double> list){
    for(auto aux : list){
        printf("  %d  ", aux);
    }
}

int main (void) {
    int sizeList = 0;
    double auxNum = 0;
    list<double> oddslist;
    list<double> list;

    do{
        list.clear();
        oddslist.clear();

        printf("\nDigite o tamanho da lista: ");
        scanf("%i", &sizeList);

        for(int i = 0; i < sizeList; i++){
            printf("\nDigite o %d numero: ", i+1);
            scanf("%d", &auxNum);

            list = addNumList(list, auxNum);
        }

        printf("Sua lista: ");
        printList(list);

        oddslist = getOddList(list, oddslist);

        printf("\nLista de numeros sem par: ");
        printList(oddslist);

        printf("\n");

    } while(sizeList>0);

    system("pause");
    return 0;
}