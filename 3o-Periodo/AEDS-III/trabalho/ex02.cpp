#include<stdlib.h>
#include<stdio.h>
#include<vector>
#include<string>
#include<iostream>

using namespace std;

vector<string> addToList(vector<string> vect, string item){
    vect.push_back(item);
    return vect;
}

void printList(vector<string> vect){
    for(int idx = 0; idx<vect.size(); idx++){
        cout << "  " << vect[idx] << "  ";
    }
}

bool existThisItem(vector<string> vect, string item){
    for(int i = 0; i<vect.size(); i++){
        if(vect[i] == item) return true;
    }
    return false;
}


int main(void){
    vector<string> product;
    string nameItem;
    int numLists;

    printf("Quantas listas serao: ");
    scanf("%d", &numLists);

    for(int i=0; i<numLists; i++){    
        product.clear();

        printf("\t----------< Lista %d >----------\n", i+1);

        do{
            cout << "Digite o nome do produto (Para sair digite \"quit\" )\nR.: ";
            cin >> nameItem;
        
            if(nameItem == "quit") continue;

            if(!existThisItem(product, nameItem)){
                product = addToList(product, nameItem);
            }
            
            printf("\n");

        } while(nameItem != "quit" );

        printf("Lista de produtos: ");
        printList(product);

        printf("\n\n");
    }

    system("pause");
    return 0;
}