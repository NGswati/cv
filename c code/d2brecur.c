#include <stdio.h>
void dtb(int n){
    if (n==1||n==0)
    printf("%d",n);
    else{
        dtb(n/2);
        printf("%d",n%2);
    }
}
int main(){
    int a;
    scanf("%d",&a);
    dtb(a);
}