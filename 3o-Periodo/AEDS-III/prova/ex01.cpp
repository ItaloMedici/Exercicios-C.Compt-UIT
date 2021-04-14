/*
    Implemente uma pequena aplicação para cadastro de músicas no banco de dados do Spotify, com funções de incluir música e uma opção para fazer busca pelo id da música. Para essa aplicação você pode definir quais atributos o registro terá, qual tipo de busca e qual será o campo chave definido.
*/

#include<stdio.h>
#include<stdlib.h>
#include<list>
#include<string.h>
#include<algorithm>

using namespace std;

// retorna uma outra lista com a lista original com o ID adicionado
list<int> addMusic(list<int> list, int ID){
    list.push_back(ID);
    return list;
}

// Retorna um booleano se existe ou não o ID na lista
// Utilizando o metodo find com a biblioteca <algorithm> usando a função find
bool findMusic(list<int> list, int ID){
    std::list<int>::iterator p;

    p = find(list.begin(), list.end(), ID);

    if(*p == ID) return true;
    return false;
}

// Imprime a lista
void printList(list<int> list){
    for(auto aux : list){
        printf("   %d   ", aux);
    }
}


int main(){
    list<int> spotify;
    int ID = 0;
    short resp = 0;

    do{
        !spotify.empty()?
        printf("\n\nEscolha:\n\t[1]-> Adicionar uma nova musica\n\t[2]-> Pesquisar uma musica\n\t[3]-> Imprimir IDs existentes\n\t[-1]-> Sair\n\t"):
        printf("\nDigite:\n\t[1]-> Adicionar uma nova musica\n\t");
        scanf("%i", &resp);

        if(resp==1){
            printf("\nDigite qual ID da musica que gostaria de adicionar: ");
            scanf("%i", &ID);

            spotify = addMusic(spotify, ID);

            printf("\nSeu banco de musicas atual: \n");
            printList(spotify);
        }

        else if(resp==2){
            printf("\nDigite qual ID da musica que gostaria de pesquisar: ");
            scanf("%i", &ID);

            findMusic(spotify, ID)?
            printf("\nEsta de musica ID: %d existe em seu banco", ID):
            printf("\nEsta de musica ID: %d NAO existe em seu banco", ID);

            printf("\nSeu banco de musicas atual: \n");
            printList(spotify);
        }

        else{
            printf("\nSeu banco de musicas atual: \n");
            printList(spotify);
        }
        
    } while(resp > 0);

    printf("\n\n");
    system("PAUSE");
    return 0;

}