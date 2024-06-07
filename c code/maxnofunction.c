#include <stdio.h>
#include <math.h>
void fun(double a,double b){
    int c=fmax(a,b);
    printf("%d\n",c);
}
int main(){
    double a,b;
    scanf("%lf%lf",&a,&b);
    fun(a,b);
}