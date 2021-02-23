#include<stdlib.h>
#include<stdio.h>

int const maxtam = 1000;

int queue[maxtam];
int front, back;

void queueCreator() {
    front = 0;
    back = -1;
}

bool isEmpty(){
    if(front>back) return true;
    else return false;
}

bool isFull(){
    if(back == maxtam-1) return true;
    else return false;
}

bool insere(int data){
    if(isFull()) return false;
    else {
        back++;
        queue[back] = data;
        return true;
    }
}

bool remove(int data){
    if(isEmpty()) return false;
    else {
        data = queue[front];
        front++;
        return true;
    }
}
