#include <stdio.h>
int fact(int a){
    if(a>0)
        return a*fact(a-1);
    else
        return 1;
}
void s(int s){
    int d=0;
    while (s!= 0)
    {
        d+=fact(s%10);
        s/=10;
    }
    printf("%d",d);
    if (s==d)
    printf("strong");
    else
    printf("not strong");
}
int main(){
    int a;
    scanf("%d",&a);
    printf("%d",fact(a));
    s(a);
}
