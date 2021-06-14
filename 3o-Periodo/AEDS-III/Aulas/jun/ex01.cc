#include <stdio.h>
#include <stdlib.h>
#include <string.h>

using namespace std;

bool isPalindromo(char *txt){
  char *copy;

  for (int i = strlen(txt) - 1; i >= 0; i--) {
    copy += txt[i];
  }

  if (strcmp(copy, txt))
    return true;

  return false;
}

int main(){
  char *string;
  scanf("%[^/n]s", &string);

  isPalindromo("tenet") ? printf("e palindromo") : printf("não e palindromo");

  system("PAUSE");
  return 0;
}