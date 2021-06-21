/* Crie uma classe denominada Elevador para armazenar as informações de um elevador dentro
de um prédio. A classe deve armazenar o andar atual (0=térreo), total de andares no prédio,
excluindo o térreo, capacidade do elevador, e quantas pessoas estão presentes nele.
 */

#include <iostream>

using namespace std;

class Elevador {
    public:
        int andarAtual;
        int andaresTotais;
        int capacidadePessoas;
        int nrPessasPresentes;
    private:
/*     ,    Elevador () {
            andarAtual = 0;
            andaresTotais = 0;
            capacidadePessoas = 0;
            nrPessasPresentes = 0;
        } */

        void inicializa(int capacidadePessoas) {
            andarAtual = 0;
            andaresTotais = 0;
            capacidadePessoas = 0;
            nrPessasPresentes = 0;
        }
};