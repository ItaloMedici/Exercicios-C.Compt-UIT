#include <stdlib.h>
#include <stdio.h>

void valor(int i){
    printf("i+2 = %d", i+2);
}

int referencia( int i){ 
    i = i + 2;
    printf (" i + 2 = %d");
}