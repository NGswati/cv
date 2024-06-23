#include <stdio.h>
int mcm(int p[], int n){
    int m[n][n];
    for (int i=1;i<n;i++)
        m[i][i]=0;
    int  z,q;
    for (int j=2;j<n;j++) {
        for (int i=1;i<n-j+1;i++){
            z=i+j-1;
            m[i][z]=__INT_MAX__;
            for (int k=i;k<=z-1;k++){
                q=m[i][k]+m[k+1][z]+p[i-1]*p[k]*p[z];
                if(q<m[i][z])
                m[i][z]=q;
            }
        }
    } 
    return m[1][n - 1];
}
 
int main(){
    int n;
    printf("Enter no. of matrices: ");
    scanf("%d",&n);
    int p[n+1];
    printf("Enter size of the matrices: ");
    for (int i=0;i<n+1;i++){
        scanf("%d",&p[i]);
    }
 
    printf("Minimum Cost : %d \n",mcm(p,n+1));

}