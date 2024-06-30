#include <stdio.h>
//time start from 0
struct job{
    int name;
    float st;
    float ft;
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
        if(L[i].ft<=R[j].ft){
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

void maxcar(struct job a[],int n){
    mergesort(a,0,n-1);
    static int j=1;
    printf("\n{ \njob %d : (%f:%f),\n",a[0].name ,a[0].st,a[0].ft);
    int b=a[0].ft;
    for(int i=1;i<n;i++){
        if(a[i].st>=b){
            printf("job %d : (%f:%f):\n",a[i].name ,a[i].st,a[i].ft);
            b=a[i].ft;
            j++;
        }
    }
    printf("}\n");
    printf("\nMaximum Cardinality: %d\n\n",j);
}
void conflict(struct job a[],int n){
    int i;
    int max=-1;
    int min=356787;
    for(int j=0;j<n;j++){
        i=-1;
        for(int k=0;k<n;k++){
            if((a[j].st<a[k].st&&a[j].ft>a[k].st)||(a[j].st<a[k].ft&&a[j].ft>a[k].ft)||(a[j].st>=a[k].st&&a[j].ft<=a[k].ft)){
                i++;
            }
        }
        if(max<i)
        max=i;
        if(min>i)
        min=i;
        printf("Number of conflicting jobs for Job %d : %d\n",a[j].name,i);
    }
    printf("\nMaximum no. of conflicts : %d\n\nMinimum No. of conflicts : %d",max,min);
}
int main(){
    int n;
    printf("Enter no. of jobs : ");
    scanf("%d",&n);
    struct job a[n];
    printf("Enter start time and finish time of N jobs : ");
    for(int i=0;i<n;i++){
        a[i].name=i+1;
        scanf("%f",&a[i].st);
        scanf("%f",&a[i].ft);
    }
    for(int i=0;i<n;i++)
    printf("job %d : (%f:%f)\n",a[i].name ,a[i].st,a[i].ft);
    maxcar(a,n);
    conflict(a,n);
    printf("\n");
    
}