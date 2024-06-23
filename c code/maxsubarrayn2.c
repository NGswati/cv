#include <stdio.h>
int main(){
    int n,max=-__INT_MAX__,sum;
    printf("Enter size of array: ");
    scanf("%d",&n);
    int a[n];
    for(int i=0;i<n;i++){
        scanf("%d",&a[i]);
    }
    int stindex=0,endindex=0;
    for(int i=0;i<n;i++){
        sum=0;
        for(int j=i;j<n;j++){
            sum+=a[j];
            if(sum>max){
                max=sum;
                stindex=i;
                endindex=j;
            }
        }
    }
    
    printf("%d\n",max);
    
    for(int i=stindex;i<endindex+1;i++){
        printf("%d, ",a[i]);
    }
}
