#include <stdio.h>
int main(){
    int a[10],i=0,j=0;
    while(i<10){
        scanf("%d",&a[i]);
        i++;
    }
    while(j<10){
        printf("%d,",a[j]);
        j++;
    }
}