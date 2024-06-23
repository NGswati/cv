#include <stdio.h>
struct al{
    int val;
    struct al *next;
};

void uml(int a[][100],struct al *b,int n){
    for(int i=0;i<n;i++){
        b[i].val=i;
        b[i].next=NULL;
        int c=i;
        for(int j=0;j<n;j++){
            if(a[i][j]==1){
                b[++c].val=j;
                //b[i].next=&b[c];
                b[c].next=NULL;
            }
        }
        for(int i=0;i<n;i++){
            int c=0;
            printf("\t%d",b[c].val);
            while(b[c++].next!=NULL){
                printf("->%d",b[c].val);
            }
            printf("\n");
        }
    }
}
int main(){
    int n;
    printf("Enter no. of rows/columns: ");
    scanf("%d",&n);
    int a[n][n];
    struct al b[n];
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++)
        scanf("%d",&a[i][j]);
    }
    uml(a,b,n);
}