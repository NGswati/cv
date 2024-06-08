#include <stdio.h>
#include <math.h>
/*int main(){
int a;
scanf("%d",&a);
if(a>1000){
printf("M");
a%=1000;}
if(a>500){
    printf("D");
    a%=500;
}
for(int i=0;i<3;i++){
if(a>100){
    printf("C");
    a%=100;
}}
for(int i=0;i<3;i++){
if(a>50){
    printf("L");
    a%=50;
}}
for(int i=0;i<3;i++){
if(a>10){
    printf("X");
    a%=10;
}}
for(int i=0;i<3;i++){
if(a>5){
    printf("V");
    a%=5;
}}
for(int i=0;i<3;i++){
if(a>1){
    printf("|");
    a%=10;
}}
return 0;
}*/
int main(){
    int d[]={1000,500,100,50,10,5,1};
    char r[]={'M','D','C','L','X','V','I'};
    int a,c=0,i=3;
    scanf("%d",&a);
    while(a!=0){
       c=(int)(a/pow(10,i))-c; 
       i--;
    }
}