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
        printf(" %s ", vect[idx].c_str());
    }
}

bool existThisItem(vector<string> vect, string item){
    for(int idx = 0; idx<vect.size(); idx++){
        if(vect[idx] == item) return true;
    }
    return false;
}


int main(void){
    vector<string> product;
    string nameItem;
    int numLists = 2;

    for(int i=0; i<numLists; i++){    
        product.clear();

        printf("\t----------< Lista %d >----------\n", i+1);

        do{
            printf("Digite o nome do produto (Para sair digite \"quit\" )\nR.: ");
            cin >> nameItem;

            if(nameItem == "quit") continue;

            if(!existThisItem(product, nameItem)){
                product = addToList(product, nameItem);
            };
            
            printf("\n");

        } while(nameItem != "quit" );

        printf("Lista de produtos: ");
        printList(product);

        printf("\n\n");
    }

    system("pause");
    return 0;
}