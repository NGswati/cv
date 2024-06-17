#include <stdio.h>
int main(){
    int a=6,b=6,c=6;
    if (a==b&&c==b)
    printf("equilateral");
    else if(a==b||b==c||c==a)
    printf("isosceles");
    else 
    printf("scalen");
}