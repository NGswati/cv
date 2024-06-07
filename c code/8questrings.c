#include<stdio.h>
#include<string.h>

int main() {
    char s[100];
    scanf("%s", s);
    char *p=s;
    for(int i=0;i<strlen(s);i++){
        for(int j=0;j<strlen(s);j++){
            printf("%c ", s[i+j]);
        }
        printf("\n");
    }

}