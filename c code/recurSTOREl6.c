#include <stdio.h>
int M[10][10];
static int count=-1;
int mcm(int i,int j,int a[],int n){
    count++;
    if(i==j){
        M[i][j]=0;
        return 0;
    }
    if(M[i][j]<__INT_MAX__)
    return M[i][j];
    int m=__INT_MAX__,q;
    for(int k=i;k<j;k++){
        q=mcm(i,k,a,n)+mcm(k+1,j,a,n)+a[i-1]*a[k]*a[j];
        if(q<m)
        m=q;
    }
    M[i][j]=m;
    return m;
}
int main(){
    int n;
    printf("Enter no. of matrices: ");
    scanf("%d",&n);
    for(int u=0;u<n+1;u++){
        for(int v=0;v<n+1;v++){
            M[u][v]=__INT_MAX__;
        }
    }  
    int p[n+1];
    printf("Enter size of the matrices: ");
    for (int i=0;i<n+1;i++){
        scanf("%d",&p[i]);
    }
    printf("Minimum Cost : %d\n",mcm(1,n,p,n));
    printf("total no. of sub problem : %d\n",count);
    printf("no of times solving each sub-problem is 1\n ");
}