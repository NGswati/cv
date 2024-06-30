#include<stdio.h>
struct job{
    int stime;
    int ftime;
};
void merge(struct job arr[],int l,int mid,int r){
    int n1=mid-l+1;
    int n2=r-mid;
    struct job L[n1];
    struct job R[n2];
    for(int i=0;i<n1;i++){
        L[i]=arr[l+i];
    }
    for(int j=0;j<n2;j++){
        R[j]=arr[mid+1+j];
    }
    int i=0,j=0,k=l;
    while(i<n1 && j<n2){
        if(L[i].ftime<=R[j].ftime){
            arr[k]=L[i];
            i++;
        }
        else{
            arr[k]=R[j];
            j++;
        }
        k++;
    }
    while(i<n1){
             arr[k]=L[i];
            i++;
            k++;


    }
     while(j<n2){
             arr[k]=R[j];
            j++;
            k++;


    }


}
void mergesort(struct job arr[],int l,int r){
    if(l<r){
        int mid=(l+r)/2;
        mergesort(arr,l,mid);
        mergesort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }
}
void maxjobs(struct job jobs[],int n){
    mergesort(jobs,0,n-1);


    int t=jobs[0].ftime;
    printf("%d %d   ",jobs[0].stime,jobs[0].ftime);
    for(int i=1;i<n;i++){
            if(jobs[i].stime>=t){
                t=jobs[i].ftime;
                printf("%d %d      ",jobs[i].stime,jobs[i].ftime);
            }


    }


}

void conflicts(struct job jobs[],int n){



    int t=jobs[0].ftime;
    int max=0;
    int min=1000;

    for(int i=0;i<n;i++){
            int k=0;
             printf("%d %d   ",jobs[i].stime,jobs[i].ftime);
            for(int j=1;j<n;j++){
                if(jobs[j].stime<jobs[i].ftime){
                    k++;


                }}
                 if(k<min){
                        min=k;
                    }
                    if(k>max){
                        max=k;
                    }


            printf("has number of conflicting jobs %d \n",k);





    }
    printf("maximum number is :%d\n",max);
            printf("minimum number is :%d\n",min);


}



int  main(){
    int n;
    printf("enter the number of jobs:");
    scanf("%d ",&n);
    struct job jobs[n];
    for(int i=0;i<n;i++){
        scanf("%d %d",&jobs[i].stime,&jobs[i].ftime);
    }
    printf("set of maximum jobs that can be scheduled:  ");
    maxjobs(jobs,n);
    printf("\n");
    conflicts(jobs,n);



}