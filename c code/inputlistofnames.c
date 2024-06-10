#include <stdio.h>
int main(){
char s[100]; 
for(int i=0;i<10;i++){
    scanf("%s",&s[i]);
}
for(int i=0;i<10;i++){
    puts(&s[i]);
}    
// puts(s);
return 0;
}