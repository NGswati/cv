#include <stdio.h>
int main(){
    printf("enter radius :");
    int a;
    scanf("%d",&a);
    printf("the diameter is %d\nthe circumference is %f\nthe area is%f",2*a,2*3.14*a,3.14*a*a);
    return 0;
}