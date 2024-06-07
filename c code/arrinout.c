#include <stdio.h>
int main(){
    int a[100];
    for (int i=0;i<100;i++){
        scanf("%d",&a[i]);
    }
    for(int i=0;i<100;i++){
        printf("%d",a[i]);
    }
}