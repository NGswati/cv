#include <stdio.h>
void merge(int a[],int a1[],int a2[],int a3[],int a4[],int w,int x,int y,int z){
    int i=0, j=0, k=0,l=0,m=0;
    while(i < w||  j < x||k<y||l<z){
        if(i==w)
            a1[i]=872656;
        if(j==x)
            a2[j]=762342;
        if(k==y)
            a3[k]=567122;
        if(l==z)
            a4[l]=786741;
        if(a1[i] < a2[j]&& a1[i] <a3[k] &&a1[i]<a4[l])
        a[m++]=a1[i++];
        else if( a2[j] <a3[k] &&a2[j]<a4[l])
        a[m++]=a2[j++];
        else if(a3[k]<a4[l])
        a[m++]=a3[k++];
        else
        a[m++]=a4[l++];
    }
}
int main(){
    int n,m,b,v,a[100];
    printf("Enter the length of array 1: ");
    scanf("%d",&n);
    printf("Enter the length of array 2: ");
    scanf("%d",&m);
    printf("Enter the length of array 3: ");
    scanf("%d",&b);
    printf("Enter the length of array 4: ");
    scanf("%d",&v);
    int ar1[10],ar2[10],ar3[10],ar4[10];
    printf("enter elements in array 1 : ");
    for(int i=0;i<n;i++){
        scanf("%d",&ar1[i]);
    }
    printf("enter elements in array 2: ");
    for(int i=0;i<m;i++){
        scanf("%d",&ar2[i]);
    }
    printf("enter elements in array 3: ");
    for(int i=0;i<b;i++){
       scanf("%d",&ar3[i]);
    }
    printf("enter elements in array 4: ");
    for(int i=0;i<v;i++){
        scanf("%d",&ar4[i]);
    }
    merge(a,ar1,ar2,ar3,ar4,n,m,b,v);
    printf("\nArray after mergesort: ");
    for(int i=0;i<n+m+b+v;i++){
        printf("%d, ",a[i]);
    }
    printf("\n");   
}