#include <stdio.h>
#include <string.h>
int main(){
char s[200],ss[100];
int a=-1;
gets(s);
gets(ss);
for(int i=0;i<strlen(s);i++){
    if(s[i]==ss[0]){
        for(int j=1;j<strlen(ss);j++){
            if(s[i+j]==ss[j])
            a=i;
            else
            a=-1;
        }
    }
}
if(a==-1)
printf("sub string is not found\n");
else
printf("sub string is found at:%d\n",a);
return 0;
}