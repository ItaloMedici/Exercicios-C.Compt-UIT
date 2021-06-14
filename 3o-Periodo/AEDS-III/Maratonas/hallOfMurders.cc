#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Killers {
  char killer[10];
  char victim[10];
} Killers;

int main() {
  char nomes[100];
  char *tmp;
  int indx = 0;
  Killers *assasins;

  while ((strcmp(nomes, "FIM") != 0)) {

    if(strcmp(nomes, "FIM") == 0) continue;

    if(!(assasins = (Killers*) malloc(sizeof(Killers)))){
      printf("Sem memoria!");
      exit(0);
    }
    
    scanf("%s", nomes);
    strcpy(assasins[indx].killer, nomes);

    printf("\n%s, ", assasins[indx].killer);

    indx++;
  } 

/*   for(int i = 0; i<size; i++) {
    fgets(nomes, 100, stdin);

    tmp = strtok(nomes, " ");
    strcpy(assasins[i].killer, tmp);

    tmp = strtok(NULL, " \n\r");
    strcpy(assasins[i].victim, tmp);

    assasins[i].murder++;
  } 
  strcpy(assasins[0].killer, tmp);

  tmp = strtok(NULL, " \n\r");
  strcpy(assasins[0].victim, tmp);
  
  printf("-> %s\n-> %s", assasins[0].killer, assasins[0].victim); */

  return 0;
}