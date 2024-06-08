#include <stdio.h>
int main(){
    int a;
    while(scanf("%d",&a)){
        if (a==0)
        break;
        while(a){
            if (a!=1)
            printf("%d",a%2);
            else
            printf("1");
            a=a/2;
        }
    }
}