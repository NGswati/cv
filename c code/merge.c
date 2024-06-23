#include <stdio.h>

void merge(int array[],int arr[],int arra[], int n1, int n2){
    int i=0, j=0, k=0;

    while (i < n1 && j < n2) {
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
 
    while (i < n1) {
        array[k] = arr[i];
        i++;
        k++;
    }
 
    while (j < n2) {
        array[k] = arra[j];
        j++;
        k++;
    }
}

int main(){
    int n,m,a[100];
    printf("Enter the length of array 1: ");
    scanf("%d",&n);
    printf("Enter the length of array 2: ");
    scanf("%d",&m);
    int ar1[n],ar2[m];
    printf("enter elements in array 1 : ");
    for(int i=0;i<n;i++){
        scanf("%d",&ar1[i]);
    }
    printf("enter elements in array 2: ");
    for(int i=0;i<m;i++){
        scanf("%d",&ar2[i]);
    }
    merge(a,ar1,ar2,n,m);
    printf("\nArray after mergesort: ");
    for(int i=0;i<n+m;i++){
        printf("%d, ",a[i]);
    }
    printf("\n");
}