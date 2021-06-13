#include<stdlib.h>
#include<stdio.h>

bool isNumExists(int *vetor, int num, int size) {
    for(int i=0 ; i<size; i++) {
        if(num == vetor[i]) return true;
    } 
    return false;
}

void getOdds(int *origin, int *odds, int size) {
    for(int i=0; i<size; i++) {
        int count = 0; 

        for(int j=0; j<size; j++) {
            origin[i] == origin[j] ? count++ : 0 ;
        }
 
        int idx = 0;
        if(count%2 != 0 && !isNumExists(odds, origin[i], size)) {
            odds[idx] = origin[i];
            idx++;
            
            printf(" %d ", origin[i]);
        }
    }
}

int main () {
    int qntd = -1;

    do {
        scanf("%d", &qntd);
        printf("\n--> nuM: %d\n", qntd);
        int nums[qntd];

        for(int i=0; i<qntd; i++) {
            scanf("%d", &nums[i]);
        }

        int lonely[qntd];
        getOdds(nums, lonely, qntd);
    } while (qntd > 0);

    return 0;
}

