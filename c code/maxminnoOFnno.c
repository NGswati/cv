#include <stdio.h>
int main(){
    int a,n=5,m=0,i=92233344;
    while(n!=0){
        scanf("%d",&a);
        if (a>m)
        m=a;
        if(a<i)
        i=a;
        n--;
    }
    printf("max:%d   min:%d",m,i);
}