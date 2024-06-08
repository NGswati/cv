#include <stdio.h>
int main(){
    int n,x=0,y=1,z;
    scanf("%d",&n);
    printf("0\t1\t");
    while ((n-2)>0){
        z=x+y;
        printf("%d\t",z);
        x=y;
        y=z;
        n--;
    }
}