#include <stdio.h>
int main(){
    int a,d,i,s=0;
    scanf("%d%d",&a,&d);
    for(i=0;i<10;i++){
        printf("%d, ",a);
        s+=a;
        a=a*d;
    }
    printf("\n%d\n",s);
}