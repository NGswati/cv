#include <stdio.h>
int main(){
    int x,p=1;
    scanf("%d",&x);
    while (x>0){
        p*=x;
        x--;
    }
    printf("%d",p);
}