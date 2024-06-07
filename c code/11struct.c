#include <stdio.h>
struct store{
    char name[100];
    int account_no;
    float balance;
};
void fun1(){
    struct store c1={"ahgcfg",1,356.78} ;
    struct store c2={"bhgcfg",2,56.78} ;
    struct store c3={"chgcfg",3,56.78} ;
    struct store c4={"dhgcfg",4,56.78} ;
    struct store c5={"ehgcfg",5,556.78} ;
    struct store c6={"fhgcfg",6,56.78} ;
    struct store c7={"ghgcfg",7,56.78} ;
    struct store c8={"hhgcfg",8,56.78} ;
    struct store c9={"ihgcfg",9,8856.78} ;
    struct store c10={"jhgcfg",10,756.78} ;
    if(c1.balance>200)
    printf("%s\n",c1.name);
    if(c2.balance>200)
    printf("%s\n",c2.name);
    if(c3.balance>200)
    printf("%s\n",c3.name);
    if(c4.balance>200)
    printf("%s\n",c4.name);
    if(c5.balance>200)
    printf("%s\n",c5.name);
    if(c6.balance>200)
    printf("%s\n",c6.name);
    if(c7.balance>200)
    printf("%s\n",c7.name);
    if(c8.balance>200)
    printf("%s\n",c8.name);
    if(c9.balance>200)
    printf("%s\n",c9.name);
    if(c10.balance>200)
    printf("%s\n",c10.name); 
}
void fun2(){
    struct store c1={"ahgcfg",1,356.78} ;
    struct store c2={"bhgcfg",2,56.78} ;
    struct store c3={"chgcfg",3,56.78} ;
    struct store c4={"dhgcfg",4,56.78} ;
    struct store c5={"ehgcfg",5,556.78} ;
    struct store c6={"fhgcfg",6,56.78} ;
    struct store c7={"ghgcfg",7,56.78} ;
    struct store c8={"hhgcfg",8,56.78} ;
    struct store c9={"ihgcfg",9,8856.78} ;
    struct store c10={"jhgcfg",10,756.78} ;
    if(c1.balance>1000){
        c1.balance=c1.balance+100;
        printf("%f\n",c1.balance);
    }
    if(c2.balance>1000){
        c2.balance=c2.balance+100;
        printf("%f\n",c2.balance);
    }
    if(c3.balance>1000){
        c3.balance=c3.balance+100;
        printf("%f\n",c3.balance);
    }
    if(c4.balance>1000){
        c4.balance=c4.balance+100;
        printf("%f\n",c4.balance);
    }
    if(c5.balance>1000){
        c5.balance=c5.balance+100;
        printf("%f\n",c5.balance);
    }
    if(c6.balance>1000){
        c6.balance=c6.balance+100;
        printf("%f\n",c6.balance);
    }
    if(c7.balance>1000){
        c7.balance=c7.balance+100;
        printf("%f\n",c7.balance);
    }
    if(c8.balance>1000){
        c8.balance=c8.balance+100;
        printf("%f\n",c8.balance);
    }
    if(c9.balance>1000){
        c9.balance=c9.balance+100;
        printf("%f\n",c9.balance);
    }
    if(c10.balance>1000){
        c10.balance=c10.balance+100;
        printf("%f\n",c10.balance);
    }


}
int main(){
    fun1();
    fun2();
return 0;
}