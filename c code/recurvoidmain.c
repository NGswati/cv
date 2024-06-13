#include <stdio.h>
void m(){
    m();//due to this, func never reach printf
    printf("hi");
}
void main(){
    m();
}