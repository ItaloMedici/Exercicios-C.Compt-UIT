#include<stdio.h>
#include<stdlib.h>

void inverter(int x[3][3], int y[3][3]){
    for(int i=0;i<3; i++){
        for(int j=0; j<3; j++){
            y[i][j] = x[j][i];
        }
    }
}

int main(){
    int mtz[3][3] = {{1,2,3},{1,2,3},{1,2,3}}, ztm[3][3];

    for(int i=0;i<3; i++){
        for(int j=0; j<3; j++){
            printf("Preencha a %d coluna %d linha: ", i+1, j+1);
            scanf("%d", &mtz[i][j]);
        }
        printf("\n");
    }

    inverter(mtz, ztm);

    for(int i=0;i<3; i++){
        for(int j=0; j<3; j++){
            printf(" %d ", mtz[i][j]);
        }
        printf("\n");
    }

    printf("\n\n");

    for(int i=0;i<3; i++){
        for(int j=0; j<3; j++){
            printf(" %d ", ztm[i][j]);
        }
        printf("\n");
    }

    
    system("pause");
    return 0;

}