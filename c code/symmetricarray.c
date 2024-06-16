#include<stdio.h>

int main()
{
int m, n;
printf("Enter the size of matrix: ");
scanf("%d%d",&m,&n);
int A[m][n];
printf("\nEnter the elements of the array in row major form: ");
for(int i=0; i<m; i++)
for(int j=0; j<n; j++)
scanf("%d", &A[i][j]);
int flag=0;
for(int i=0; i<m; i++)
for(int j=0; j<n; j++)
{
if(A[i][j]!=A[j][i])
{
flag=1;
break;
}

}

if(flag==1)
printf("\nAsymmetric Matrix");
else
printf("\nSymmetric Matrix");
}