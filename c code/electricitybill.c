#include <stdio.h>
int main(){
    printf("enter electricity units :");
    int s;
    scanf("%d",&s);
    if (s<=50)
    printf("bill is %lf",s*0.5);
    else if (s<=150&&s>50)
    printf("bill is %lf",25+(s-50)*.75);
    else if(s<=250&&s>150)
    printf("bill is %lf",100+(s-150)*1.2);
    else
    printf("bill is %lf",220+(s-250)*1.5); 
    
    return 0;
}