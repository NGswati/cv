#include <stdio.h>
struct student {
    int roll;
    char name[19];
    int age;
};
void fu(int i){
    struct student s1={1,"ram",7};
    struct student s2={2,"sam",15};
    struct student s3={3,"fam",23};
    struct student s4={4,"pam",65};
    struct student s5={5,"oam",12};
    if(i==1)
    printf("%d %s %d\n",s1.roll,s1.name,s1.age);
    else if(i==2)
    printf("%d %s %d\n",s2.roll,s2.name,s2.age);
    else if(i==3)
    printf("%d %s %d\n",s3.roll,s3.name,s3.age);
    else if(i==4)
    printf("%d %s %d\n",s4.roll,s4.name,s4.age);
    else if(i==5)
    printf("%d %s %d\n",s5.roll,s5.name,s5.age);
    else
    printf("invalid input");
}
int main(){
    int i;
    scanf("%d",&i);
    fu(i);
return 0;
}