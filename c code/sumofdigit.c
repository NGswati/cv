#include <stdio.h>
int main(){
    printf("enter a three digit no.:");
    int s;
    scanf("%d",&s);
    printf("sum of digits=%d",s%10+s/100+(s%100)/10);
    return 0;
}