#include <stdio.h>
void merge1(int array[],int arr[],int arra[], int n1, int n2){
    int i=0, j=0, k=0;

    while (i < n1 || j < n2) {
        if(i==n1){
            arr[i]=872656;
        }
        else if(j==n2){
            arra[j]=762342;
        }
        if (arr[i] <= arra[j]) {
            array[k] = arr[i];
            i++;
        }
        else {
            array[k] = arra[j];
            j++;
        }
        k++;
    }

}



void merge(int a[],int aa1[],int aa2[],int a1[],int a2[],int a3[],int a4[], int n1, int n2,int n3,int n4){
    int i=0, j=0, k=0,l=0,m=0;
    merge1(aa1,a1,a2,n1,n2);
    merge1(aa2,a3,a4,n3,n4);
    merge1(a,aa1,aa2,n1+n2,n3+n4);
}

int main(){
    int n,m,b,v,a[100],aa1[100],aa2[100];
    printf("Enter the length of array 1: ");
    scanf("%d",&n);
    printf("Enter the length of array 2: ");
    scanf("%d",&m);
    printf("Enter the length of array 3: ");
    scanf("%d",&b);
    printf("Enter the length of array 4: ");
    scanf("%d",&v);
    int ar1[n],ar2[m],ar3[b],ar4[v];
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
    merge(a,aa1,aa2,ar1,ar2,ar3,ar4,n,m,b,v);
    printf("\nArray after mergesort: ");
    for(int i=0;i<n+m+b+v;i++){
        printf("%d, ",a[i]);
    }
    printf("\n");
}