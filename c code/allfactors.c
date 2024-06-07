#include <stdio.h>
int main(){
    int x,i;
    scanf("%d",&x);
    while (i<=x){
        if (x%i==0)
        printf("%d\t",i);
        i++;
    }
    return 0;
}
