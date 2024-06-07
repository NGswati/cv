#include <stdio.h>
int main(){
    char a;
    scanf("%c",&a);
    if (a=='a'||a=='e'||a=='i'||a=='o'||a=='u'||a=='A'||a=='E'||a=='I'||a=='O'||a=='U')
    a='a';
    else if((a>'A'&&a<'Z')||(a>'a'&&a<'z'))
    a='e';
    switch(a){
        case 'a':
        printf("vowel");
        break;
        case'e':
        printf("consonant");
        break;
        default :
        printf("enter alphabet");
    }
}