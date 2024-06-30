#include <stdio.h>
void merge(int arr[],int l,int mid,int r){

    int n1=mid-l+1;
    int n2=r-mid;
    
    int L[n1+1];
    int R[n2+1];

    for(int i=0;i<n1;i++){
        L[i]=arr[l+i];
    }
    for(int j=0;j<n2;j++){
        R[j]=arr[mid+j+1];
    }

    L[n1]=10000;
    R[n2]=10000;
    
    int i=0,j=0,m=l;
    
    while(i < n1||j < n2){
        if(L[i] < R[j])
        arr[m++]=L[i++];
        else 
        arr[m++]=R[j++];
    }
}

void mergesort(int a[],int l,int r){
    if(l<r){       
        int mid=(l+r)/2;  
        mergesort(a,l,mid);
        mergesort(a,mid+1,r);
        merge(a,l,mid,r);
    }
}
void minpetrolpump(int p[],int d[],int n,int c){
    int count=1,cur_c=c,x=d[0];
    for(int i=1;i<n;i++){
        if(d[i]<cur_c)
        x=d[i];
        else{
            count++;
            cur_c+=c;
        }         
    }
    printf("Minimum No. of petrol pump: %d\n",count);
}

//0 78 112 37 90 67 233 48 59 189 158 194
int main(){
    int n;
    printf("Enter the no. of petrol pumps: ");
    scanf("%d",&n);
    int p[]={1,2,3,4,5,6,7,8,9,10,11,12};
    int d[n];
    printf("Enter the respective distance from initial position(in km): ");
    for(int i=0;i<n;i++){
        scanf("%d",&d[i]);
    }
    printf("Enter Capacity: ");
    int capacity;
    scanf("%d",&capacity);//L
    //milage 1km/L
    mergesort(d,0,n-1);
    minpetrolpump(p,d,n,capacity);
}



// for(int i=0;i<11;i++){
//     printf("%d ",d[i]);
// }
//  int count=1,cur_c=c;
//     for(int i=1;i<n;i++){
//         cur_c-=d[i];
//         if(d[i+1]>cur_c){
//             count++;
//             cur_c=c;
//             //p[i]++;
//         }     
//     }