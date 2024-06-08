#include <stdio.h>
int main(){
int n,c,x,y; 
scanf("%d",&n);
while(n){
    scanf("%d%d%d",&c,&x,&y);
    if(c<n)
    printf("%d",0);
    else
    {
        printf("%d",(c-x)*y);  
    }
    n--;
}
return 0;
}