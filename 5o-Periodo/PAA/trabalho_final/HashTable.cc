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

  for (int i{}; i < n; i++)
    sum += table[i].size();  

  return !sum;
}

// Pega o Hash atraves da Chave MOD n
int HashTable::getHash(int key) {
  return key % n;
}

void HashTable::insertItem(int key, string value) {
  int hash = getHash(key);
  auto& cell = table[hash];

  auto interator = begin(cell);
  bool exists = false;

  for (; interator != end(cell); interator++) {
    if (interator->first == key) {
      exists = true;
      interator->second = value;

      cout << "CIU ja existe, Aluno foi substituido" << endl;
      break;
    }
  }

  if (!exists) {
    cell.emplace_back(key, value);
  }

  return;
}

void HashTable::removeItem(int key) {
  int hash = getHash(key);
  auto& cell = table[hash];

  auto interator = begin(cell);
  bool exists = false;

  for (; interator != end(cell); interator++) {
    if (interator->first == key) {
      exists = true;
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

  for (int i = 0; i < n; i++) {
    cout << i << " = ";

    if (table[i].size() == 0) {
      cout << endl;
      continue;
    };

    auto interator = table[i].begin();
    for (; interator != table[i].end(); interator++) {
      cout << "| CIU: " << interator->first << " Aluno: " << interator-> second << " | -> " ;
    }

    cout << endl;
  }
}

string HashTable::search(int key) {
  int hash = getHash(key);
  auto& cell = table[hash];

  auto interator = begin(cell);
  bool found = false;

  for (; interator != end(cell); interator++) {
    if (interator->first == key) {
      found = true;
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
