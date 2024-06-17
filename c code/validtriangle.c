#include <stdio.h>
int main(){
    printf("enter 3 angles");
    int a,b,c;
    scanf("%d",&a);
    scanf("%d",&b);
    scanf("%d",&c);
    if (a+b+c==180&& a>0&&b>0&&c>0)
    printf("triangle is valid");
    else
    printf("triangle is invalid");
    return 0;
}