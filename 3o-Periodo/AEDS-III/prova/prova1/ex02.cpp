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

/* long mediaTree(Node *root){
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
 */
 
int count(Node *root){
    int cL=0, cR=0;
    if(root == NULL){
        return 0;
    }
    cL = count(root->Left);
    cR = count(root->Right);

    return(cR + cL + 1);
}

int somaTree(Node *root){
    int sL=0, sR=0;
    int count=0;
    if(root == NULL){
        return 0;
    }
    sL = somaTree(root->Left);
    sR = somaTree(root->Right);

    return(root->Reg.Chave + sL + sR);
}



int main (){
    Node *root = initializeTree();

    Registro x;
    Registro y;
    Registro z;
    Registro o;
    x.Chave = 12;
    y.Chave = 15;
    z.Chave = 5;
    o.Chave = 8;

    root = insertTree(root, x);
    root = insertTree(root, y);
    root = insertTree(root, z);
    root = insertTree(root, o);


    printTree(root);
    
    printf("\nMedia da arvore: %d", somaTree(root)/count(root));

    printf("\n\n");
    system("PAUSE");
    return 0;
}