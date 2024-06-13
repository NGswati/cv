#include <stdio.h>
int main(){
    int b,n,a[100];
    for(int i=0;n!=-1;i++){
        scanf("%d",&n);
        if(n==-1)
        break;
        a[i]=n;
        b=i;
    }
    // for(int j=1;j<=b;j++){
    //     printf("%d, ",a[b-j]);
    // }
    //2nd ques
    int c;
    for(int i=0;i<b/2;i++){
        c=a[b];
        a[b-i]=a[i];
        a[i]=c;
    }
    for(int j=0;j<b;j++){
        printf("%d, ",a[b]);
    }
       
}