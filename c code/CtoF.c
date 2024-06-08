#include <stdio.h>
int main(){
    printf("enter C temperature :");
    double t;
    scanf("%lf",&t);
    printf("F temperature is %lf",t*9/5+32);
    return 0;
}