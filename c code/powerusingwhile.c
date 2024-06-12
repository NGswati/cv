#include <stdio.h>
int main(){
    int x,y,p=1;
    scanf("%d",&x);
    scanf("%d",&y);
    while (y>0){
        p*=x;
        y--;
    }
    printf("%d",p);
}