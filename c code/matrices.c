#include <stdio.h>
// void matrix_mul(){

// }
void mm_recur(int a[][4],int b[][4],int c[][4],int i,int j,int k,int l,int w,int x,int y,int z){
    int m,n,o,p;

    if(n==0)
    //c[0][0]=a[0][0]*b[0][0];
    else{
        c[][]=mm_recur(int )
    }

}
int main(){
    int n;
    printf("Enter size of matrix: ");
    scanf("%d",&n);
    int a[n][n],b[n][n],c[n][n];
    printf("Enter elements in matrix 1: ");
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            scanf("%d",&a[i][j]);
        }
    }
    printf("Enter elements in matrix 2: ");
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            scanf("%d",&a[i][j]);
        }
    }
    mm_recur(a,b,c,0,0,n,n,0,0,n,n);
}