#include <iostream>
#include <string.h>

using namespace std;

class Killer {
    private:
        string name;
        string victim;
        int murders;
        bool dead;
        int id;
    public:
        Killer () {
            name = "";
            victim = "";
            murders = 0;
            dead = false;
            id = 0;
        }
        void setName(string name) {
            this->name = name;
        }
        void setVictim(string victim) {
            this->victim = victim;
        }
        void setMurders(int murders) {
            this->murders = murders;
        }
        void setDead(bool dead) {
            this->dead = dead;
        }
        void setId(int id) {
            this->id = id;
        }

        string getName() {
            return name;
        }
        string getVictim() {
            return victim;
        }
        int getMurders() {
            return murders;
        }
        bool getIsDead() {
            return dead;
        }
        int getId() {
            return id;
        }

        void printKiller() {
            cout << name << "\t" << murders << endl;
        }
};

bool contains(string s1, string s2) {
    if(s1.find(s2) != string::npos){
        return true;
    }
    return false;
}

int main () {
    int quantidade;
    cout << "Digite quantos assasinos: ";
    cin >> quantidade;

    Killer killers[quantidade];

    string killerName;
    string allKillersNames;

    string victimName;
    string allVictimsNames;

    for(int i=0; i<quantidade; i++){

        cout << "Nome do assasino: ";
        cin >> killerName;

        if(!contains(allKillersNames, killerName)){
            allKillersNames += killerName;

            cout << allKillersNames << "\t" << killerName << endl;

            killers[i].setName(killerName);
            killers[i].setId(i);
            killers[i].setMurders((killers[i].getMurders())+1);
        } else {
            for(Killer k : killers) {
                if(k.getName() ==  killerName) {
                    int murderCount = k.getMurders()+1;
                    k.setMurders(murderCount);
                    cout 
                        << endl 
                        << "Mortes: " << k.getMurders() 
                        << "Note: " << k.getName() 
                        << endl;
                }
            }
            i--;
        }   

        cout << "Nome da vitima: ";
        cin >> victimName;

        if(contains(allKillersNames, victimName)) {
            for(Killer k : killers) {
                if(k.getName() ==  victimName) {
                    k.setDead(true);
                }
            }
        }

        killers[i].setVictim(victimName);
    }

    for(Killer k : killers) {
        if(k.getIsDead() == false) {
            k.printKiller();
        }
    }

    return 0;
}