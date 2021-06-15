#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct status {
  int id;
  bool dead;
  int murders;
} Status;

typedef struct Killers {
  char killer[10];
  char victim[10];
  Status status;
} Killers;

bool contains(int *vet, int key, int size) {
  for(int i=0; i<size; i++) {
    if(vet[i] == key) return true;
  }
  return false;
}


int main() {
  char *tmp;
  int indx = 0;

  Killers *assasins;
  assasins = (Killers *) malloc(sizeof(Killers));

  while (true) {
    char nomes[100];

    assasins = (Killers*) realloc(assasins, sizeof(Killers) + 1);

    if(assasins == NULL){
      printf("Sem memoria!");
      free(assasins);
      exit(0);
    }

    assasins[indx].status.dead = false;
    assasins[indx].status.murders = 0;
    assasins[indx].status.id = indx;
    
    scanf("%s", nomes);
    if(strcmp(nomes, "FIM") == 0) break;
    strcpy(assasins[indx].killer, nomes);

    scanf("%s", nomes);
    if(strcmp(nomes, "FIM") == 0) break;
    strcpy(assasins[indx].victim, nomes);

    indx++;
  } 

  int controlId[indx];
  
  for(int i=0; i<indx; i++) {
    int id = assasins[i].status.id;

    for(int j=0; j<indx; j++) {
      if(strcmp(assasins[i].killer, assasins[j].killer) && !contains(controlId, id, indx)) {
        controlId[i] = id;
        assasins[i].status.murders++;
        printf("\n-> id: %d, matador: %s, mortes: %d", id, assasins[i].killer, assasins[i].status.murders);
      }
      if(strcmp(assasins[i].killer, assasins[j].victim)) {
        assasins[i].status.dead = true;
      }
    }
  }

  return 0;
}