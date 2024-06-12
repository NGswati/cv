#include <stdio.h>
int sf(int x){
    if(x==0)
    return 0;
    else
    return x+sf(x-1);
}
int main(){
    int n;
    scanf("%d",&n);
    printf("no. of handshakes :%d",sf(n-1));
}