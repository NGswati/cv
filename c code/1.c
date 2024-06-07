#include <stdio.h>
int main()
{
    float a,b,c;
    float d;
    printf("enter here");
    scanf("%f%f%f",&a,&b,&c);
    d=1/((1/a)+(1/b)+(1/c));
    printf("total resistance%f",d);
    return 0;
}