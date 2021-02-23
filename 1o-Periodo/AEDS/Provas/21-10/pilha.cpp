#include<stdlib.h>
#include<stdio.h>

int const maxtam = 1000;

int stack[maxtam];
int top;

void stackCreator() {
    top = -1;
}

bool isEmpty(){
    if(top == -1) return true;
    else return false;
}

bool isFull(){
    if(top == maxtam) return true;
    else return false;
}

bool empilhar(int data){
    if(isFull()) return false;
    else {
        top++;
        stack[top] = data;
        return true;
    }
}

bool desempilhar (int &valor){
    if(isEmpty()) return false;
    else {
        valor = stack[top];
        top--;
        return true;
    }
}                        