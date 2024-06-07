#include <stdio.h>
int fun(int a,int b){
    for(int i=a;i>0;i--){
        int c=i;
        if(i>b){
            i=b;
            b=c;
        }
        if(b%i==0){
            return i;
            break;}
    }
    return 0;
}
int main(){
    int a,b,c;
    scanf("%d%d%d",&a,&b,&c);
    printf("%d",fun(a,fun(b,c)));
}