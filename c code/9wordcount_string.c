#include <stdio.h>
#include <string.h>
int main(){
char s[100];
gets(s);
int a=0;
for(int i=0;i<strlen(s);i++){
    if(s[i]==' ')
    a++;
}
printf("%d",a+1);
return 0;
}