#include <stdio.h>
int main(){
    printf("enter alphabet");
    char s;
    scanf("%c",&s);
    if (s=='a'||s=='e'||s=='i'||s=='o'||s=='u')
    printf("vowel");
    else
    printf("consonent");
    return 0;
}