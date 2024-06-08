#include <stdio.h>
void fun(int a){
    int d=0;
    while (a%10!=0){
        a=a/10;
        d++;
    }
    printf("%d",d);
}
int main(){
    int a;
    scanf("%d",&a);
    fun(a);
}