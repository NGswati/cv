#include <stdio.h>
int f(int x){
    if(x==1)
    return 0;
    else if(x==3||x==2)
    return 1;
    else
    return f(x-2)+f(x-1);
}
int main(){
    int a;
    scanf("%d",&a);
    printf("%d",f(a));
}