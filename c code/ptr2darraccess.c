#include <stdio.h>
int main()
{
    int a[4][5];


    for(int i=0;i<4;i++)
    {
        for(int j=0;j<5;j++)
        {
            scanf("%d",&a[i][j]);
        }
    }

    int *ptr=a;
    for(int i=0;i<4;i++)
    {
        for(int j=0;j<5;j++)
            printf("%d ", *(ptr+(5*i+j)));
        printf("\n");
    }
    

    return 0;
}