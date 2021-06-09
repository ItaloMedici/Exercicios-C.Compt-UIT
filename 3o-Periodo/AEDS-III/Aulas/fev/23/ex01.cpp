#include<stdlib.h>
#include<stdio.h>

int expo(int num, int exp){
    if(num==0) return 1;
    else return num*expo(num, exp-1);
}

int main(){
    printf("%d", expo(5,5));

    system("pause");
}