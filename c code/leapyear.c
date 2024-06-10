#include <stdio.h>
int main(){
    printf("enter year");
    int s;
    scanf("%d",&s);
    if (s%4==0)
    printf("leap year");
    else
    printf("not leap year");
    return 0;
}