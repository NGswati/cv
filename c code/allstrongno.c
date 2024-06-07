#include <stdio.h>
int main(){
    int r=0,f=1,i=1,j=1,s=500,a,b=s/100,c=s%10;
    while (s>0){
        while (c>0){
            f*=c;
            c--;
        }
        r+=f;
        while (b>0){
            i*=b;
            b--;   
        }
        r+=i;
        a=(s%100)/10;
        //printf("%d",a);
        while (a>0){
            j*=a;
            a--;
        }
        r+=j;
        printf("%d\n",j);
        //printf("%d\n",r);
        if(s==r)
        //printf("%d\t",s);
        r=0;
        s--;
        //printf("%d",s);
    }
}