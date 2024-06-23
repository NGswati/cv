#include <stdio.h>
void merge(int a[],int ll,int m1,int m2,int m3,int r){
    
    int w=m1-ll+1;
    int x=m2-m1;
    int y=m3-m1;
    int z=r-m3;

    int a1[w+1],a2[x+1],a3[y+1],a4[z+1];

    for(int i=0;i<w;i++)
    a1[i]=a[ll+i];
    for(int j=0;j<x;j++)
    a2[j]=a[m1+1+j];
    for(int k=0;k<y;k++)
    a3[k]=a[m2+1+k];
    for(int l=0;l<z;l++)
    a4[l]=a[m3+1+l];

    a1[w]=1000;
    a2[x]=1000;
    a3[y]=1000;
    a4[z]=1000;
    int i=0, j=0, k=0,l=0,m=ll;
    while(i < w||  j < x||k<y||l<z){
        if(a1[i] < a2[j]&& a1[i] <a3[k] &&a1[i]<a4[l])
        a[m++]=a1[i++];
        else if(a1[i] > a2[j]&&a2[j] <a3[k] &&a2[j]<a4[l])
        a[m++]=a2[j++];
        else if(a1[i] > a3[j]&&a3[i] < a2[j]&&a3[k]<a4[l])
        a[m++]=a3[k++];
        else 
        a[m++]=a4[l++];
    }
}

void mergesort(int a[],int l,int r){
    if(l<r){
        int mid=(l+r)/2;
        int mid1=(l+mid)/2;
        int mid2=(mid+r+1)/2;
        mergesort(a,l,mid1);
        mergesort(a,mid1+1,mid);
        mergesort(a,mid+1,mid2);
        mergesort(a,mid2+1,r);
        merge(a,l,mid1,mid,mid2,r);
    }
}
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