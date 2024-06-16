#include <stdio.h>
int main(){
    int i=1,j;
    for (j=6;(j>=0)&&(i<=5);i++){
        printf("%d%d\n",j,i);
    }
    for(int sum=0,i=1;i<5;sum+=1,++i){
        printf("%d",sum);
    }
    
}