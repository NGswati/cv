#include <stdio.h>
int main(){
    int x,s=0;
    scanf("%d",&x);
    while (x){
        if (x%2==0)
        s+=x;
        x--;
    }
    printf("%d",s);
}