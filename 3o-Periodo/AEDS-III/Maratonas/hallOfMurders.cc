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

bool containsId(int *vet, int key, int size) {
  for(int i=0; i<size; i++) {
    if(vet[i] == key) return true;
  }
  return false;
}

bool containsName(char *name, Killers *assasins, int size) {
  for(int i=0; i<size; i++) {
    if(strcmp(assasins[i].killer, name)) return true;
  }
  return false;
}

// pesquisar id do assasino por nome
/* int getIdByName(char *name) */


int main() {
  char *tmp;
  int indx = 0;

  Killers *assasins;
  assasins = (Killers *) malloc(sizeof(Killers));

  while (true) {
    char nomes[100];

    assasins = (Killers*) realloc(assasins, sizeof(Killers));

    if(assasins == NULL){
      printf("Sem memoria!");
      free(assasins);
      exit(0);
    }

    assasins[indx].status.dead = false;
    assasins[indx].status.murders = 0;
    assasins[indx].status.id = indx + 1;
    
    scanf("%s", nomes);
    if(strcmp(nomes, "FIM") == 0){ 
      break;
    } else if (!containsName(nomes, assasins, indx)){
      strcpy(assasins[indx].killer, nomes);
    }
    /* else  */
      // adicionar uma pesquisa de id para não haver duplicatas do mesmo assasino
    scanf("%s", nomes);
    if(strcmp(nomes, "FIM") == 0) break;
    strcpy(assasins[indx].victim, nomes);

    //printf("\n-> id: %d, matador: %s, mortes: %d", assasins[indx].status.id, assasins[indx].killer, assasins[indx].status.murders);

    indx++;
  } 

  int controlId[indx];
  
  for(int i=0; i<indx; i++) {
    int id = assasins[i].status.id;

    for(int j=0; j<indx; j++) {
      if(strcmp(assasins[i].killer, assasins[j].killer) && !containsId(controlId, id, indx)) {
        controlId[i] = id;
        assasins[i].status.murders++;
        printf("\n-> id: %d, matador: %s, mortes: %d", id, assasins[i].killer, assasins[i].status.murders);
      }
      if(strcmp(assasins[i].killer, assasins[j].victim)) {
        assasins[i].status.dead = true;
      }
    }
  }

  free(assasins);
  return 0;
}