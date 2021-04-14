/*
    Implemente uma função que calcule a média de todos os elementos que estão inseridos em uma árvore binária. Qual é o tipo de percurso usado na sua implementação?
*/

#include <stdlib.h>
#include <stdio.h>

typedef struct reg {
    int Chave;
} Registro;

typedef struct Node{
    Registro Reg;
    struct Node* Left;
    struct Node* Right;
} Node;

Node *initializeTree(){
    return NULL;
}

Node *insertTree(Node *root, Registro x) {
    if (root == NULL) {
        Node *aux = (Node *)malloc(sizeof(Node));
        aux->Reg = x;
        aux->Left = NULL;
        aux->Right = NULL;
        return aux; 
    } 
    else {
        if (x.Chave > root->Reg.Chave){
            root->Right = insertTree(root->Right, x);
        }
        else if(x.Chave < root->Reg.Chave){
            root->Left = insertTree(root->Left, x);
        }
    } 
    return root;
}

void printTree(Node *root){
    if(root != NULL){
        printf(" %d ", root->Reg.Chave);
        printTree(root->Left);
        printTree(root->Right);
    }
}

long mediaTree(Node *root){
    long sum=0;
    long count=0;
    if(root != NULL){
        sum += root->Reg.Chave;
        count++;
        mediaTree(root->Left);
        mediaTree(root->Right);
    }
    return (sum/count);
}


int main (){
    Node *root = initializeTree();

    Registro x;
    Registro y;
    Registro z;
    Registro o;
    x.Chave = 1;
    y.Chave = 2;
    z.Chave = 3;
    o.Chave = 4;

    root = insertTree(root, x);
    root = insertTree(root, y);
    root = insertTree(root, z);
    root = insertTree(root, o);


    printTree(root);

    printf("\n\n%d", mediaTree(root));

    printf("\n\n");
    system("PAUSE");
    return 0;
}