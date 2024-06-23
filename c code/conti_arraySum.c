#include <stdio.h>

int main(){
    int n,j=0,count=0,c2=0;
    scanf("%d",&n);
    int a[n];
    for (int i=0;i<n;i++){
        scanf("%d",&a[i]);
    }
    
    for(int i=0;i<n;i++){ 
        if(a[i]==a[j]){
            count++;
        }
        else{
            c2=count;
            printf("%d occurs %d times\n",a[j],c2);
            count=1;
            j=i;
        }

    }
    count=0;
    for(int i=0;i<n;i++){
        if(a[i]==a[n-1])
        count++;

    }
    printf("%d occurs %d times\n",a[n-1],count);
    
    // for(int i=0;i<n;i++){
    //     for(int j=0;j<n;j++){
    //         if(a[i]==a[j])
    //         count++;
    //     }
    //     if(a[i]!=a[i+1]){
    //     printf("%d : %d\n",a[i],count);
    //     }
    //     count=0;
    // }
}
