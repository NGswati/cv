#include<stdio.h>
int count=0;
int isSafe(int arr[100][100],int x,int y,int n){
    int row,col;
    for(int i=0;i<x;i++){
        if(arr[i][y]==1)
        return 0;
    }
    for(int i=0;i<x;i++){
        if(arr[x][i]==1)
        return 0;
    }
    row=x;
    col=y;
    while(row>=0&&col>=0){
        if(arr[row][col]==1){
            return 0;
        }
        row--;
        col--;
    }
    row=x;
    col=y;
    while(row>=0&&col<n){
        if(arr[row][col]==1){
        return 0;
        }
        row--;
        col++;
    }
    return 1;
}
int nQueen(int  arr[100][100],int x,int n){
    int flag=0;
    if(x>=n){
        for(int i=0;i<x;i++){
            for(int j=0;j<n;j++){
                printf("%d ",arr[i][j]);
                flag=1;
            }
            if(flag==1){
                count++;
            }
            flag=0;
            printf("\n");
        }
        return 1;
    }
    for(int c=0;c<n;c++){
        if(isSafe(arr,x,c,n)){
            arr[x][c]=1;
            nQueen(arr,x+1,n);
        }
        arr[x][c]=0;
        }
        printf("\n");
    return 0;
}

int main(){
    int n;
    printf("Enter number of queens: ");
    scanf("%d",&n);
    int arr[100][100];
    if(nQueen(arr,0,n)){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                printf("%d ",arr[i][j]);
            }
            printf("\n");
        }
        printf("%d\n",count);
    }
}
