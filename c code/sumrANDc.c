#include <stdio.h>
int main(){
    int const i=2,j=2;
    int a[i][j]={1,2,3,4},sumr=0,suml=0;
    for(int r=0;r<i;r++){
        for(int l=0;l<j;l++){
            sumr+=a[r][l];
            suml+=a[l][r];
        }
        printf("sum of row %d=%d\n",r,sumr);
        printf("sum of column %d=%d\n",r,suml);
        sumr=0;
        suml=0;
    }
}