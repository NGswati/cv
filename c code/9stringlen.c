#include <stdio.h>
int sl(char s[]){
    int a=0;
    for(int i=0;s[i]!='\0';i++){
        a++;
    }
    return a;
}
int main(){
    char s[100];
    gets(s);
    printf("string length =%d",sl(s));
return 0;
}