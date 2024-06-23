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

int power(int i,int j){
    if(j==0)
    return 1;
    else
    return i*power(i,j-1);
}

int main(){
    int n;
    printf("Please enter the number of cupcakes: ");
    scanf("%d",&n);
    int a[n];
    printf("Enter Respective calorie counts of each cupcake: ");
    for(int i=0;i<n;i++){
        scanf("%d",&a[i]);
    }
    mergesort(a,0,n-1);
    int m=n-1,sum=0,x;
    for(int j=0;j<n;j++){
        x=power(2,j)*a[m--];
        sum+=x;
    }
    printf("Marc should walk at least %d miles.\n",sum);
    
}