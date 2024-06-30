#include <stdio.h>
int a1[3];
int a2[3];

int * maxcrosssubarray(int A[],int l,int mid,int h){
    int leftsum=0;
    int sum=0;
    int maxleft;
    for(int i=mid;i>=l;i--){
        sum=sum+A[i];
        if(sum>leftsum){
            leftsum=sum;
            maxleft=i;
        }
    }
    int rightsum=0;
    sum=0;
    int maxright;
    for(int j=mid +1;j<=h;j++){
        sum=sum+A[j];
        if(sum>rightsum){
            rightsum=sum;
            maxright=j;
        }
    }
    a1[0]=maxleft;
    a1[1]=maxright;
    a1[2]=leftsum+rightsum;
    return a1;
}

int * maxsubarray(int A[],int l,int h){
    if(h==l){
        int mid;
        a2[0]=l;
        a2[1]=h;
        a2[2]=A[l];
        return a2;

    }
    else{
        int mid=(l+h)/2;
        int llow,lhigh,lsum;
        int rlow,rhigh,rsum;
        int clow,chigh,csum;

        llow=*maxsubarray(A,l,mid);
        lhigh=*(maxsubarray(A,l,mid)+1);
        lsum=*(maxsubarray(A,l,mid)+2);

        rlow=*(maxsubarray(A,mid+1,h));
        rhigh=*(maxsubarray(A,mid+1,h)+1);
        rsum=*(maxsubarray(A,mid+1,h)+2);

        clow=*(maxcrosssubarray(A,l, mid, h));
        chigh=*(maxcrosssubarray(A,l, mid, h)+1);
        csum=*(maxcrosssubarray(A,l, mid, h)+2);

        if(lsum>=rsum&&lsum>=csum){
            a2[0]=llow;
            a2[1]=lhigh;
            a2[2]=lsum;
            return a2;
        }
        else if(rsum>=csum){
            a2[0]=rlow;
            a2[1]=rhigh;
            a2[2]=rsum;
            return a2;
        }
        else {
            a2[0]=clow;
            a2[1]=chigh;
            a2[2]=csum;
            return a2;  
        }
    }
}

 //4 3 9 17 2 8 4 27 1 5 
// -1 6 8 -15 6 -4 23 -26 4
int main(){
    int n;
    printf("Enter the total no. of consecutive days: ");
    scanf("%d",&n);
    int d[n];
    printf("Enter the respective price for each day: ");
    for(int i=0;i<n;i++){
        scanf("%d",&d[i]);
    }
    int p[n-1];
    for(int i=1;i<n;i++){
        p[i-1]=d[i]-d[i-1];
    }
    int *m=maxsubarray(p,0,n-1);
    int r=*m;
    int q=*(m+1);
    int sum;
    for(int i=0;i<n-1;i++){
        printf("%d",p[i]);
    }
    
    for(int i=r;i<=q;i++){
        sum=sum+p[i];
    }
    if(sum>0&&n>1){
        printf("\nbuying day for the stocks is : %d st\\nd\\rd\\th",r+1);
        printf("\nselling day for the stocks is: %d st\\nd\\rd\\th",q+2);
        printf("\nmax profit Rs %d per share\n",sum*1000);
    }
    else
    printf("\nthere was no way to make money during the %d day/s\n",n);
    
}

    // for(int i=0;i<n-1;i++){
    //     printf("%d",p[i]);
    // }
