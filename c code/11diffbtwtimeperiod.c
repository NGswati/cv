#include <stdio.h>
struct timeperiod{
    int hour;
    int min;
    int sec;
};
int main(){
struct timeperiod t1={2,32,56};
struct timeperiod t2={1,54,36};
int a=t1.hour*3600+t1.min*60+t1.sec,b=t2.hour*3600+t2.min*60+t2.sec;
int c=a-b;
printf("%dseconds",c);
return 0;
}