#include<stdio.h>
int main(){
    int n,m,sum=0;
    scanf("%d",&n);
    for(m=1;m<n;m++){
        for (int i = 1; i<m; i++){
        if (m%i==0){
        sum+=i;
        }
        if (sum==m)
        printf("%d",m);
        }}}