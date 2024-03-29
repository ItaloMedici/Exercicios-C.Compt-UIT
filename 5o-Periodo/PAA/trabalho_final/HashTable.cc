#include <iostream>
#include <list>
#include <cstring>
using namespace std;

#define SIZE 10

class HashTable {
  private: 
    static const int n = SIZE;
    list<pair<int, string>> table[n];

  public: 
    bool isEmpty();
    int getHash(int key);
    void insertItem(int key, string value);
    void removeItem(int key);
    string search(int key);
    void print();
};

bool HashTable::isEmpty() {
  int sum{};

  // Verificamos se a tabela está vazia somando os tamanhos das listas 
  for (int i{}; i < n; i++)
    sum += table[i].size();  

  // Se 0 então true se > 0 então false
  return !sum;
}

// Pega o Hash atraves da Chave MOD n
int HashTable::getHash(int key) {
  return key % n;
}

// Insereo item através da chave
void HashTable::insertItem(int key, string value) {
  int hash = getHash(key);

  // Acessa a linha com o indice gerado pelo hash
  auto& cell = table[hash];

  // Inicia um interator no começo da lista
  auto interator = begin(cell);
  bool exists = false;

  // Percorre a lista verificando se já existe um CIU duplicado
  for (; interator != end(cell); interator++) {
    if (interator->first == key) {
      exists = true;

      // Se existe, sobrescrevemos o valor
      interator->second = value;

      cout << "CIU ja existe, Aluno foi substituido" << endl;
      break;
    }
  }

  // Se não existir, adiciona no final da lista
  if (!exists) {
    cell.emplace_back(key, value);
  }

  return;
}

// Remove um intem apatir do CIU
void HashTable::removeItem(int key) {
  int hash = getHash(key);

  // Acessa a linha com o indice gerado pelo hash
  auto& cell = table[hash];

  // Inicia um interator no começo da lista
  auto interator = begin(cell);
  bool exists = false;

  // Percorre a lista verificando se realmente existe esse CIU
  for (; interator != end(cell); interator++) {
    if (interator->first == key) {
      exists = true;
      // Se existe, removemos esse aluno da lista
      interator = cell.erase(interator);
      cout << "CIU encontrada, Aluno foi removido!" << endl;
      break;
    }
  }

  if (!exists) {
    cout << "CIU nao encontrada, Aluno nao foi removido!" << endl;
  }

  return;
}

void HashTable::print() {
  if (isEmpty()) return;

  // Percorremos a tabela
  for (int i = 0; i < n; i++) {
    cout << i << " = ";

    // Se não houver dados na lista ele sai
    if (table[i].size() == 0) {
      cout << endl;
      continue;
    };

    // Percorremos a lista com dados
    auto interator = table[i].begin();
    for (; interator != table[i].end(); interator++) {
      // Para cada Aluno na lista imprimimos
      cout << "| CIU: " << interator->first << " Aluno: " << interator-> second << " | -> " ;
    }

    cout << endl;
  }
}

string HashTable::search(int key) {
  int hash = getHash(key);

  // Acessa a linha com o indice gerado pelo hash
  auto& cell = table[hash];

  auto interator = begin(cell);
  bool found = false;

  // Percorremos a lista até o final e verificamos se é a mesma chave
  for (; interator != end(cell); interator++) {
    if (interator->first == key) {
      found = true;
      // Se encontrou retorna esse aluno
      return interator->second;
    }
  }

  return "";
}

int main(int argc, char const *argv[]) {
  HashTable hashTable;

  hashTable.insertItem(82157, "Italo");
  hashTable.insertItem(85477, "Joao Paulo");
  hashTable.insertItem(36978, "Isis");
  hashTable.insertItem(23228, "Aim");
  hashTable.insertItem(23228, "Aimee");
  hashTable.insertItem(85478, "Daniel");

  hashTable.print();

  hashTable.removeItem(85477);
  hashTable.removeItem(23228);
  cout << endl << "Removendo Joao e Aimee" << endl;
  hashTable.print();

  hashTable.insertItem(22, "Joao Paulo");
  hashTable.insertItem(134, "Aimee");
  cout << endl << "Adicionando outro Joao e Aimee" << endl;
  hashTable.print();

  cout << endl << "Procurando CIU 36978" << endl;
  string found = hashTable.search(36988);

  if (found != "") {
    cout << " Aluno: " << found << endl;
  } else {
    cout << " Aluno nao encontrado" << endl;
  }

  return 0;
}
