#include <stdio.h>
void merge(int arr[],int ll,int p,int mid,int q,int r){

    int n1=p-ll+1;
    int n2=mid-p;
    int n3=q-mid;
    int n4=r-q;
    int L[n1+1];
    int R[n2+1];
    int L1[n3+1];
    int R1[n4+1];
    

    for(int i=0;i<n1;i++){
        L[i]=arr[ll+i];
    }
    for(int j=0;j<n2;j++){
        R[j]=arr[p+j+1];
    }
    for(int k=0;k<n3;k++){
        L1[k]=arr[mid+k+1];
    }
    for(int t=0;t<n4;t++){
        R1[t]=arr[q+t+1];
    }


    L[n1]=1000;
    R[n2]=1000;
    L1[n3]=1000;
    R1[n4]=1000;
    int i=0,j=0,k=0,l=0,m=ll;
    while(i < n1||  j < n2||k<n3||l<n4){
        if(L[i] < R[j]&& L[i] <L1[k] &&L[i]<R1[l])
        arr[m++]=L[i++];
        else if(R[j] <L1[k] &&R[j]<R1[l])
        arr[m++]=R[j++];
        else if(L1[k]<R1[l])
        arr[m++]=L1[k++];
        else 
        arr[m++]=R1[l++];
    }
}

void mergesort(int a[],int l,int r){
    if(l<r){
        int mid=(l+r-1)/2;
        int mid1=(l+mid-1)/2;
        int mid2=(mid+r-1)/2;
        mergesort(a,l,mid1);
        mergesort(a,mid1+1,mid);
        mergesort(a,mid+1,mid2);
        mergesort(a,mid2+1,r);
        merge(a,l,mid1,mid,mid2,r);
    }
}
//12 4 5 3 2 1 7 6 33 90 45 13 8 89 23 15
int main(){
    int n;
    printf("Enter size of array: ");
    scanf("%d",&n);
    int a[n];
    printf("Enter elements: ");
    for(int i=0;i<n;i++){
        scanf("%d",&a[i]);
    }
    printf("array before mergesort: ");
    for(int i=0;i<n;i++){
        printf("%d ,",a[i]);
    }
    mergesort(a,0,n-1);
    printf("\narray after mergesort: ");
    for(int i=0;i<n;i++){
        printf("%d ,",a[i]);
    }
    printf("\n");
}