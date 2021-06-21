/* Crie uma classe para representar uma pessoa, com os atributos privados de nome, idade e altura.
Crie os métodos públicos necessários para sets e gets e também um métodos para imprimir os
dados de uma pessoa. */

#include <iostream>

using namespace std;

class Pessoa {
    private:
        string nome;
        float altura;
        int idade;
    public:
        Pessoa() {
            nome = "";
            altura = 0;
            idade = 0;
        }

        void setNome(string nome) {
            this->nome = nome;
        }
        void setAltura(float altura) {
            this->altura = altura;
        }
        void setIdade(int idade) {
            this->idade = idade;
        }

        string getNome() {
            return nome;
        }
        float getAltura() {
            return altura;
        }
        int getIdade() {
            return idade;
        }

        void printPessoa() {
            cout << "Nome: " << nome << "\nIdade: " << idade << "\nAltura: " << altura;
        }
};

int main () {
    Pessoa p1;
    p1.setNome("Italo Medici");
    p1.setAltura(1.75);
    p1.setIdade(19);

    p1.printPessoa();

    return 0;
}