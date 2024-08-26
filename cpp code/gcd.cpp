#include <iostream>
using namespace std;
int gcd(int x,int y){
    if(x==1||y==1)
    return 1;
    else if(y==0)
    return x;
    else if(x==0)
    return y;
    else{
        if(x%y==0)
        return y;
        else if(y%x==0)
        return x;
        else {
            if(x>y)
            return gcd(x,x%y);
            else
            return gcd(y,y%x);
        } 
    }
}
int power(int x,int n){
    if(n==0)
    return 1;
    else
    return x*power(x,n-1);
}
int mul(int a,int b){
    if(b==0)
    return 0;
    else
    return a+mul(a,b-1);
}
int main(){
    int a,b;
    scanf("%d%d",&a,&b);
    printf("%d\n",gcd(a,b));
    printf("%d\n",power(a,b));
    printf("%d\n",mul(a,b));
}