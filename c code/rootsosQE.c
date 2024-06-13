#include <stdio.h>
#include <math.h>
int main(){
    int a, b ,c;
    printf("enter a b c");
    scanf("%d",&a);
    scanf("%d",&b);
    scanf("%d",&c);
    printf("quadratic equation : %dx2+%dx+%d\n",a,b,c);
    printf("roots are %f,%f\n",(-b+sqrt(b*b-4*a*c))/2.0*a,(-b-sqrt(b*b-4*a*c))/2.0*a);
    return 0;
}