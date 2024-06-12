#include <stdio.h>
int main(){
    int i=0,j=0,n;
    scanf("%d",&n);
    for(;i<n;i++){
        for(j=0;j<i;j++){
            printf(" ");
        }
        for(j=i;j<n;j++){
            printf("*");
        }
        // for(j=i;j<n;j++){
        //     printf("*");
        // }
        printf("\n");
    }
}