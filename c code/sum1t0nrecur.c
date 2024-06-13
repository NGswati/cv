#include <stdio.h>
int sf(int x){
    if(x==0)
    return x;
    else
    return x+sf(x-1);
}
int main(){
    int a;
    scanf("%d",&a);
    printf("%d",sf(a));
}