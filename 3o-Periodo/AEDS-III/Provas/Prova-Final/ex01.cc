/* 
  Implemente uma pequena aplicação para cadastro de motoristas, com funções de incluir motorista, e uma opção para fazer busca pelo número da carteira de motorista. Para essa aplicação você pode definir quais atributos o registro terá, qual tipo de busca e qual será o campo chave definido.
 */

#include<iostream>
#include<list>
#include<stdlib.h>

using namespace std;

class Motorista {
  private:
    int carteira;
    string nome;
  public:
    Motorista() {
      carteira = 0;
      nome = "";
    }

    void setMotorista(string nome, int carteira) {
      this->nome = nome;
      this->carteira = carteira;
    }

    int getCarteira() {
      return carteira;
    }

    void printMotorista() {
      cout << "Nome: " << nome << endl << "Carteira: " << carteira;
    }
};

void getMotorista(int carteira, list<Motorista> motoristas){
  for(auto m : motoristas) {
    if(m.getCarteira() == carteira) {
      m.printMotorista();
      return;
    }
  }
  cout << "Nao encontrado!!";
}   


int main (void) {
  list<Motorista> motoristas;
  Motorista m;

  string nome;
  int carteira;
  int resp;
  bool loop = true;

  while(loop) {
    system("cls||clear");
    cout << "\tMenu" << endl
        << " 1 - Adicionar motorista " << endl
        << " 2 - Pesquisar Motorisa " << endl
        << " 3 - Sair" << endl
        << "Resp: ";
    cin >> resp;

    switch (resp){
    case 1:
      cout << "Nome: ";
      cin >> nome;
      cout << "Carteira: ";
      cin >> carteira; 

      m.setMotorista(nome, carteira);
      motoristas.push_front(m);
      break;
    case 2:
      cout << "Carteira: ";
      cin >> carteira;
      getMotorista(carteira, motoristas);
    case 3:
      loop = false;
      break;
    default:
      break;
    }
  }

  return 0;
}