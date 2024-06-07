#include <stdio.h>
#include <string.h>
void copy(char s1[],char s2[]){
    for(int i=0;i<strlen(s1);i++){
        s2[i]=s1[i];
    }
}
int main(){
char s1[100],s2[]={};
gets(s1);
printf("copied string is");
copy(s1,s2);
puts(s2);
return 0;
}
