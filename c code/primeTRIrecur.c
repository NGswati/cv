#include <stdio.h>
int prime(int n){
    int x=2,s=0;
    while (x<=n){
        if (n%x!=0)
        s+=1;
        x++;
    }
    if (s==(n-2))
    return n;
}
int main(){
    int a,b=2;
    scanf("%d",&a);
    for(int i=0;i<a;i++){
        for(int j=0;j<=i;j++){
            if (b==prime(b))
            printf("%d",b);
            else
            j--;
            b++;
        }
        printf("\n");
    }
}