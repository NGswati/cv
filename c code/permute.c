#include <stdio.h>
#include <string.h>
void swap(char *a,char *b){
    char c;
    c=*a;
    *a=*b;
    *b=c;
}
// void permutation(char *a, int l, int ){
//     int i;

// }
int main(){
    char s[]={"abcd"};
    scanf("%s",s);
    for (int i=0;i<strlen(s);i++){
        swap(&s[0],&s[i]);
        puts(s);
    }
    // int n=strlen(s);
    // permutation(s,0,n-1);
    return 0;
}