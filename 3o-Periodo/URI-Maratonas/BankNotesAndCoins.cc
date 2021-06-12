#include <stdlib.h>
#include <stdio.h>

int main () {
  float valor;
  scanf("%f", &valor);
  
  int notas[6] = {0,0,0,0,0,0,0};
  float moedas[6] = {0,0,0,0,0,0};
  int nmsNts[7] = {100,50,20,10,5,2,1};
  
  int notas = atof(valor);

  if(valor >= 100) {
    notas[0] = (valor - (valor%100))/100;
    valor %= 100;
  } 
  if(valor >= 50) {
    notas[1] = valor / 50;
    valor %= 50;
  }
  if(valor >= 20) {
    notas[2] = valor / 20;
    valor %= 20;
  }
  if(valor >= 10) {
    notas[3] = valor / 10;
    valor %= 10;
  }
  if(valor >= 5) {
    notas[4] = valor / 5;
    valor %= 5;
  }
  if(valor >= 2) {
    notas[5] = valor / 2;
    valor %= 2;
  }


  printf("%d",aux);
  for(int i = 0; i<7; i++) {
    printf("\n%d nota(s) de R$ %d,00", notas[i], nmsNts[i]);
  }
  return 0;
}
