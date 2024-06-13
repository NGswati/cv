#include <stdio.h>
int recur(int n){
    if (n==2)
    return 2;
    else
    return "+"+recur(n-1); 
}
int main(){
    printf("%d\t",recur(6));
}