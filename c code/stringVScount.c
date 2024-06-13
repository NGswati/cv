#include <stdio.h>
#include <string.h>
int main(){
char s[100];
int a,v;
gets(s);
puts(s);
for(int i=0;i<strlen(s);i++){
    if(s[i]=='a'||s[i]=='e'||s[i]=='i'||s[i]=='o'||s[i]=='u')
    v++;
    else if(s[i]==' ')
    a++;
}
printf("vowels:%d\n",v);
printf("spaces:%d\n",a);
return 0;
}