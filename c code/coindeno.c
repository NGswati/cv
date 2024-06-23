#include <stdio.h>
void merge(int arr[],int l,int mid,int r){

    int n1=mid-l+1;
    int n2=r-mid;
    
    int L[n1+1];
    int R[n2+1];

    for(int i=0;i<n1;i++){
        L[i]=arr[l+i];
    }
    for(int j=0;j<n2;j++){
        R[j]=arr[mid+j+1];
    }

    L[n1]=10000;
    R[n2]=10000;
    
    int i=0,j=0,m=l;
    
    while(i < n1||j < n2){
        if(L[i] < R[j])
        arr[m++]=L[i++];
        else 
        arr[m++]=R[j++];
    }
}

void mergesort(int a[],int l,int r){
    if(l<r){       
        int mid=(l+r)/2;  
        mergesort(a,l,mid);
        mergesort(a,mid+1,r);
        merge(a,l,mid,r);
    }
}
void distr(int a[],int n,int r){
    mergesort(a,0,n-1);

    int count=0,b[n][2],i=0;
    n--;
    while(r>=a[0]){
        if (r>=a[n]){
           r-=a[n];
           count++;
        }
        else if(count>0){
            b[i][0]=count;
            b[i++][1]=a[n--];
            count=0;
        }
        else
        n--;
    }
    b[i][0]=count;
    b[i++][1]=a[n];
    if(r==0){
        printf("Your denominations: ");
        for(int j=0;j<i;j++){
            printf("%d x %d, ",b[j][0],b[j][1]);
        }
        printf("\n");
    }
    else
    printf("change for your amount is not posible\n");

}
int main(){
    int n,r;
    printf("Enter no. of coin denomination: ");
    scanf("%d",&n);
    int a[n];
    printf("Please enter denominations: ");
    for(int i=0;i<n;i++){
        scanf("%d",&a[i]);
    }
    printf("Please enter the amount you want to change: ");
    scanf("%d",&r);
    distr(a,n,r);
    printf("\n");
}