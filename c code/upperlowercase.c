#include <stdio.h>
int main(){
    printf("enter char");
    char s;
    scanf("%c",&s);
    if (s<91&&s>64)
    printf("upper case");
    else if (s<123&&s>96)
    printf("lower case");
    return 0;
}