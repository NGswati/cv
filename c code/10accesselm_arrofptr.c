#include <stdio.h>
int main(){
int a[]={1,2,3,4,5};
int *ptr=a;
// printf("%p", ptr);


for(int i=0;i<5;i++)
{
    printf("value at %d: %d\n", i+1, *(ptr+i));
}
return 0;
}
