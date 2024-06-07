#include <stdio.h>
int n_211;
void f_211(int a_211[][n_211]){
    int m_211 = -2345,id_211;
    for (int i_211 = 0; i_211 < n_211; i_211++) {
        int sum_211 = 0;
        for (int j_211 = 0; j_211 < n_211; j_211++) {
            sum_211 += a_211[i_211][j_211];
        }
        if (sum_211> m_211) {
            m_211 = sum_211;
            id_211 = i_211;
        }
    }
    printf("Index:%d\nSum:%d\n",id_211,m_211);
}
int main(){
scanf("%d",&n_211);
int a_211[n_211][n_211];
for(int i_211=0;i_211<n_211;i_211++){
    for(int j_211=0;j_211<n_211;j_211++){
        scanf("%d",&a_211[i_211][j_211]);
    }
}
f_211(a_211);
printf("%d",n_211);
return 0;
}