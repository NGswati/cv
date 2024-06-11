#include <stdio.h>
#include <math.h>
int main(){
    printf("enter 3 nors.");
    int s,a,b;
    scanf("%d",&s);
    scanf("%d",&a);
    scanf("%d",&b);
    if (a>b&&a>s)
    printf("max no. is %d",a);
    else if (b>a&&b>s)
    printf("max no. is %d",b);
    else
    printf("max no. is%d",s);
    return 0;
}