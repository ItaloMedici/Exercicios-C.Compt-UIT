#include<stdlib.h>
#include<stdio.h>
#include<vector>
#include<string>

using namespace std;

vector<string> addList(vector<string> list, string name){
    list.push_back(name);
}

void printVec(vector<string> list){
    for(int idx = 0; idx<list.size(); idx++){
        printf(" %s \n", list[idx].c_str());
    }
}


int main(void){
    vector<string> produtos;

    printVec(produtos);

    system("pause");
    return 0;
}