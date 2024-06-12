#include <stdio.h>
int main(){
    int x=2,n,s=0;
    scanf("%d",&n);
    while (x<n){
        if (n%x!=0)
        s+=1;
        x++;
    }
if (s==(n-2))
printf("prime");
else
printf("not prime");
}