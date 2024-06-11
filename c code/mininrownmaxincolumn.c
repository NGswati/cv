#include <stdio.h>
int main(){
    int a[3][3]={4,9,1,6,8,6,5,9,1},m=-1000000000,n=100000000;
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            if(a[i][j]>m)
            m=a[i][j];
        }
        for(int j=0;j<3;j++){
            if(a[j][i]<n)
            n=a[j][i];
        }
        if(n==m)
        printf("%d",m);
    }
}