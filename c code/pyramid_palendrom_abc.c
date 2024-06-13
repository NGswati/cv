#include <stdio.h>
int main(){
    char a='A';
    for(int i=0;i<9;i++){
        for(int s=0;s<9-i;s++)printf("  ");
        for(int c=0;c<2*i+1;c++){
            if(c<i){printf("%c ",a);
            ++a;}
            else{printf("%c ",a);
            --a;}
        }
    a='A';
    printf("\n");    
    }
}