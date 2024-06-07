#include <stdio.h>
#include <string.h>
int main(){
int f_211=0,t_211=0,s_211=0;
char a_211[100],b_211[100];
gets(a_211);
gets(b_211);

for (int i_211 = 0; a_211[i_211] != '\0'; i_211++) {
    if(a_211[i_211]==' '||a_211[i_211]=='.') {
        t_211++ ;
      }
   }
for (int i_211 = 0; b_211[i_211] != '\0'; i_211++) {
    if(b_211[i_211]==' '||b_211[i_211]=='.') {
        s_211++ ;
      }
   }


if((strlen(a_211)-t_211)==(strlen(b_211)-s_211)){
    for(int i_211=0;i_211<strlen(a_211);i_211++){
        for(int j_211=0;j_211<strlen(b_211);j_211++){
            if(a_211[i_211]==b_211[j_211]||(a_211[i_211]-32)==b_211[j_211]||a_211[i_211]==(b_211[j_211]-32)){
                a_211[i_211]='1';
                b_211[j_211]='2';
                f_211++;
            }
        }
    }
}
if(f_211==(strlen(a_211)-t_211))
printf("SAME");
else
printf("Not SAME");
return 0;
}