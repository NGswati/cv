#include <stdio.h>
int main(){
    int n,c=0;
    scanf("%d",&n);
    while(n){
        for(int i=2;i<n;i++){
            if(n%i==0)
            {c=1;
            break;}
        }
        if(c==0&&n>1)
        printf("%d\t",n);
        n--;
        c=0;
    }
}