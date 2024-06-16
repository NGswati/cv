#include <stdio.h>
int main(){
    int a,b,c;
    scanf("%d",&a);
    scanf("%d",&b);
    scanf("%d",&c);
    (a>b)?(b>c?printf("%d",a):0):(b>c?printf("%d",b):printf("%d",c));
}