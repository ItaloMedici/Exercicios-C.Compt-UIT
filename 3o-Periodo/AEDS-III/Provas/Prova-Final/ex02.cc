/* Crie uma classe PESSOA com os seguintes atributos: nome, idade, endereço e data de nascimento. Essa classe deverá ter um método para cadastrar os dados da pessoa. No entanto, a idade deverá ser calculada a partir da data de nascimento, através de outro método com retorno. Os outros dados deverão ser solicitados para o usuário digitar. Por fim, crie um método para mostrar os dados da PESSOA. Na função principal (main()), crie pelo menos uma instância da classe PESSOA. */


#include<iostream>
#include<stdlib.h>
#include <ctime>

using namespace std;

tm createDate(int dia, int mes, int ano) {
  tm dt = {0};

  dt.tm_year = ano - 1900; 
  dt.tm_mon = mes - 1;  
  dt.tm_mday = dia;  

  return dt;
}

class Data {
  private:
    int dia;
    int mes;
    int ano;
  public:
    void setDia(int dia) {
      this->dia = dia;
    }
    void setMes(int mes) {
      this->mes = mes;
    }
    void setAno(int ano) {
      this->ano = ano;
    }
    int getDia() {
      return dia;
    }
    int getMes() {
      return mes;
    }
    int getAno() {
      return ano;
    }
};

class Pessoa:Data {
  private:
    string nome;
    string endereco;
    int idade;
    Data nascimento;
  public:
    void setNome(string nome) {
      this->nome = nome;
    }
    void setEndereco(string endereco) {
      this->endereco = endereco;
    }
    void setIdade(int idade) {
      this->idade = idade;
    }
    void setNascimento(int dia, int mes, int ano) {
      this->nascimento.setDia(dia);
      this->nascimento.setMes(mes);
      this->nascimento.setAno(ano);
    }
    string getNome() {
      return nome;
    }
    string getEndereco() {
      return endereco;
    }
    int getIdade() {
      return idade;
    }
    int getDia() {
      return nascimento.getDia();
    }
    int getMes() {
      return nascimento.getMes();
    }
    int getAno() {
      return nascimento.getAno();
    }

    int calcIdade(tm diaAtual) {
      tm nasicmento;

      nasicmento = createDate(nascimento.getDia(), nascimento.getMes(), nascimento.getAno());

      time_t dt1 = mktime(&nasicmento);
      time_t dt2 = mktime(&diaAtual);

      const int seconds_per_day = 60*60*24;

      int diferencaEmdias = difftime(dt2, dt1) / seconds_per_day;
      int idade = diferencaEmdias / 365;

      return idade;
    }

    void printPessoa() {
      system("cls||clear");
      cout << "Nome: "       <<  nome    << endl
           << "Edereco: "    << endereco << endl
           << "Idade: "      << idade    << endl
           << "Nascimento: " << nascimento.getDia() <<"/"<< nascimento.getMes() <<"/"<<nascimento.getAno();
    }
};




int main() {
  Pessoa pessoa;
  tm nasicmento;

  time_t dt;
  dt = time(NULL);
  tm diaAtual = *localtime(&dt); 

  string nome;
  string endereco;
  int dia;
  int mes;
  int ano;
  int idade;

  cout << "Nome: ";
  cin >> nome;

  cout << "Endereco: ";
  cin >> endereco;

  cout << "Dia de nascimento: ";
  cin >> dia;

  cout << "Mes (numero do mes): ";
  cin >> mes;

  cout << "Ano: ";
  cin >> ano;


  pessoa.setNome(nome);
  pessoa.setEndereco(endereco);
  pessoa.setNascimento(dia, mes, ano);

  pessoa.setIdade(pessoa.calcIdade(diaAtual));
  pessoa.printPessoa();

  return 0;
}