#include <stdio.h>
int f_211(int n_211){
    if(n_211==1)
    return 1;
    else if(n_211==2)
    return 3;
    else
    return 3*f_211(n_211-1)+2*f_211(n_211-2);
}
    

int main(){
int n_211;
scanf("%d",&n_211);
for(int i_211=1;i_211<=n_211;i_211++){
    printf("L%d=%d\t",i_211,f_211(i_211));
}
return 0;
}