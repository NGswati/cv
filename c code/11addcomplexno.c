#include <stdio.h>
struct n {
    int r;
    int i;
};
void cadd(){
    int r1,i1,r2,i2;
    scanf("%d %d %d %d",&r1,&i1,&r2,&i2);
    struct n n1={r1, i1};
    struct n n2={r2, i2};
    printf("addition=%d+j%d",r1+r2,i1+i2);
}
int main(){
    cadd();

}