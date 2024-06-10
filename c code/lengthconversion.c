#include <stdio.h>
int main(){
    printf("enter length(in cm):");
    int s;
    scanf("%d",&s);
    printf("length(in m):%lfm\nlength(in km):%lfkm",s/100.,s/1000.);
    return 0;
}