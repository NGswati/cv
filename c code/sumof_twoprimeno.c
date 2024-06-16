#include <stdio.h>
int main(){
    int a,b,c=a+b,x=2,s=0,t=0;
    scanf("%d%d%d",&a,&b,&c);
    while (x<a){
        if (a%x!=0)
        s+=1;
        x++;
    }
    x=2;
    while (x<b){
        if (b%x!=0)
        t+=1;
        x++;
    }
    if(s==(a-2)&&t==(b-2)){
        if(a+b==c)
        printf("yes");
        else 
        printf("no");
    }
}