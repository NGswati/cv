#include<stdio.h>
int a1[3];
int a2[3];
int a3[3];
int * maxcrosssubarray(int A[],int l,int mid,int h){
    int leftsum=-__INT_MAX__;
    int sum=0;
    int maxleft;
    for(int i=mid;i>=l;i--){
        sum=sum+A[i];
        if(sum>leftsum){
            leftsum=sum;
            maxleft=i;
        }
    }
    int rightsum=-__INT_MAX__;
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
            a3[0]=llow;
            a3[1]=lhigh;
            a3[2]=lsum;
            return a3;
        }
        else if(rsum>=csum){
            a3[0]=rlow;
            a3[1]=rhigh;
            a3[2]=rsum;
            return a3;
        }
        else {
            a3[0]=clow;
            a3[1]=chigh;
            a3[2]=csum;
            return a3;  
        }
    }
}

int  main(){
    int arr[]={5,-3,1,4,-2,8,-6};
    int * m=maxsubarray(arr,0,7);
    int p=*m;
    int q=*(m+1);
    printf("%d \n",m[0]);
    for(int i=p;i<=q;i++){
        printf("%d ",arr[i]);
    }

}
