#include <stdio.h>
#include <math.h>
struct point
{
    int x;
    int y;
};
int arr[][2]={{3,4},{1,2},{7,8},{1,12},{7,19},{13,18},{89,23},{5,8}};
int n=6;
int Px[6][2];
int Py[6][2];
struct point_2
{
    int x1;
    int y1;
    int x2;
    int y2;
};
typedef struct point_2 Struct2;
typedef struct point Struct;
Struct px[6];
Struct py[6];
Struct2 set_points;



void merge_x(int arr[][2],int temp[][2],int left,int mid,int right)
{
    int pos=left;
    int size=right-left+1;
    int i;
    int left_end=mid-1;
    while(left<=left_end && mid<=right)
    {
        if(arr[left][0]<=arr[mid][0])
        {
            temp[pos][0]=arr[left][0];
            temp[pos][1]=arr[left][1];
            pos++;
            left++;
        }
        else
        {
            temp[pos][0]=arr[mid][0];
            temp[pos][1]=arr[mid][1];
            mid++;
            pos++;
        }
    }
    while(left<=left_end)
    {
        temp[pos][0]=arr[left][0];
        temp[pos][1]=arr[left][1];
        pos++;
        left++;
    }
    while(mid<=right)
    {
        temp[pos][0]=arr[mid][0];
        temp[pos][1]=arr[mid][1];
        mid++;
        pos++;
    }
    for(i=0;i<size;i++)
    {
        arr[right][0]=temp[right][0];
        arr[right][1]=temp[right][1];
        right--;
        
    }
    
}
void merge_sort_x(int arr[][2],int temp[][2],int start,int end)
{
    if(end>start)
    {
        int mid;
        mid=(start+end)/2;
        merge_sort_x(arr,temp,start,mid);
        merge_sort_x(arr,temp,mid+1,end);
        merge_x(arr,temp,start,mid+1,end);
    }
}
void merge_y(int arr[][2],int temp[][2],int left,int mid,int right)
{
    int pos=left;
    int size=right-left+1;
    int i;
    int left_end=mid-1;
    while(left<=left_end && mid<=right)
    {
        if(arr[left][1]<=arr[mid][1])
        {
            temp[pos][1]=arr[left][1];
            temp[pos][0]=arr[left][0];
            pos++;
            left++;
        }
        else
        {
            temp[pos][1]=arr[mid][1];
            temp[pos][0]=arr[mid][0];
            mid++;
            pos++;
        }
    }
    while(left<=left_end)
    {
        temp[pos][1]=arr[left][1];
        temp[pos][0]=arr[left][0];
        pos++;
        left++;
    }
    while(mid<=right)
    {
        temp[pos][1]=arr[mid][1];
        temp[pos][0]=arr[mid][0];
        mid++;
        pos++;
    }
    for(i=0;i<size;i++)
    {
        arr[right][1]=temp[right][1];
        arr[right][0]=temp[right][0];
        right--;
        
    }
}
void merge_sort_y(int arr[][2],int temp[][2],int start,int end)
{
    if(end>start)
    {
        int mid;
        mid=(start+end)/2;
        merge_sort_y(arr,temp,start,mid);
        merge_sort_y(arr,temp,mid+1,end);
        merge_y(arr,temp,start,mid+1,end);
    }
}
float distance_cal(Struct p1,Struct p2)
{
    return sqrt( (p1.x - p2.x)*(p1.x - p2.x) +
                 (p1.y - p2.y)*(p1.y - p2.y));
}
Struct2 bruteforce(Struct px[],int n)
{
    int i,j;
    float distance;
    int start;
    int end;
    float min_distance=1000000000;
    int dist=0;
    for(i=0;i<n;i++)
    {
        for(j=i+1;j<n;j++)
        {
            distance=distance_cal(px[i],px[j]);
            if(distance<min_distance)
            {
                min_distance=distance;
                set_points.x1=px[i].x;
                set_points.y1=px[i].y;
                set_points.x2=px[j].x;
                set_points.y2=px[j].y;
            }
        }
    }
    return set_points; 
}
Struct2 strip_closest(Struct strip[],int n,Struct2 min_left_right)
{
    float min;
    int start;
    int end;
    Struct2 close_points;
    Struct min_left_r[2];
    min_left_r[0].x=min_left_right.x1;
    min_left_r[0].y=min_left_right.y1;
    min_left_r[1].x=min_left_right.x2;
    min_left_r[1].y=min_left_right.y2;
    min=distance_cal(min_left_r[0],min_left_r[1]);
    int i,j;
    for(i=0;i<n;++i)
    {
        for(j=i+1;j<n && (strip[j].y-strip[i].y)<min;++j)
        {
            if(distance_cal(strip[j],strip[i])<min)
            {
                min=distance_cal(strip[i],strip[j]);
                close_points.x1=strip[i].x;
                close_points.y1=strip[i].y;
                close_points.x2=strip[j].x;
                close_points.y2=strip[j].y;
            }
        }
    }    
    return close_points;
}
Struct2 closest_pair_recursion(Struct px[],Struct py[],int n)
{
    if(n<=3)
    {
        return bruteforce(px,n);
    }
    int mid=n/2;
    Struct midpoint;
    midpoint=px[n/2];
    Struct left[mid];
    Struct right[n-mid];
    int index_left=0;
    int index_right=0;
    int i;
    for(i=0;i<n;i++)
    {
        if(midpoint.x<=px[i].x)
        {
            right[index_right].x=px[i].x;
            right[index_right].y=px[i].y;
            index_right++;
        }
        else
        {
            left[index_left].x=px[i].x;
            left[index_left].y=px[i].y;
            index_left++;
        }
    }
    Struct2 _left=closest_pair_recursion(px,left,n/2);
    Struct2 _right=closest_pair_recursion(px+mid,right,n/2);
    Struct2 min_left_right;
    Struct left_temp[2];
    Struct right_temp[2];
    left_temp[0].x=_left.x1;
    left_temp[0].y=_left.y1;
    left_temp[1].x=_right.x2;
    left_temp[1].y=_left.y2;
    right_temp[0].x=_right.x1;
    right_temp[0].y=_right.y1;
    right_temp[1].x=_right.x2;
    right_temp[1].y=_right.y2;
    if(distance_cal(left_temp[0],left_temp[1])<=distance_cal(right_temp[0],right_temp[1]))
    {
        min_left_right.x1=_left.x1;
        min_left_right.y1=_left.y1;
        min_left_right.x2=_left.x2;
        min_left_right.y2=_left.y2;
    }
    else
    {
        min_left_right.x1=_right.x1;
        min_left_right.y1=_right.y1;
        min_left_right.x2=_right.x2;
        min_left_right.y2=_right.y2; 
    }
    Struct min_left_r[2];
    min_left_r[0].x=min_left_right.x1;
    min_left_r[0].y=min_left_right.y1;
    min_left_r[1].x=min_left_right.x2;
    min_left_r[1].y=min_left_right.y2;
    float dist_min_r_l=distance_cal(min_left_r[0],min_left_r[1]);
    Struct strip[n];
    int j=0;
    for(i=0;i<n;i++)
    {
        if((int)(py[i].x-midpoint.x)<dist_min_r_l)
        {
            strip[j++]=py[i];
        }
    }
    return strip_closest(strip,j,min_left_right);

    }
    Struct2 closest_pair(int arr[][2],int n)
    {
    int temp[100][2];
    int i=0,j=0;
    for(i=0;i<n;i++)
    {
        for(j=0;j<2;j++)
        {
            Px[i][j]=arr[i][j];
        }
    }
    for(i=0;i<n;i++)
    {
        for(j=0;j<2;j++)
        {
            Py[i][j]=arr[i][j];
        }
    }
    merge_sort_x(Px,temp,0,n-1);
    merge_sort_y(Py,temp,0,n-1);
    for(i=0;i<n;i++)
    {
        px[i].x=Px[i][0];
        px[i].y=Px[i][1];
        
    }
    for(i=0;i<n;i++)
    {
        py[i].x=Py[i][0];
        py[i].y=Py[i][1];
    }
    return closest_pair_recursion(px,py,n);

}
int main()
{
    Struct2 closest;
    closest=closest_pair(arr,n);
    printf("(%d,%d) and (%d,%d)",closest.x1,closest.y1,closest.x2,closest.y2);
    
}
