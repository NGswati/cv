#include <stdio.h>
int aa[100][3];
static int count = -1;
static int lim = 0;
int mcm(int i, int j, int a[], int n)
{
    count++;
    for (int k = 0; k < (lim + 1); k++)
    {
        if ((aa[k][0] == i) && (aa[k][1] == j))
            aa[k][2]++;
        else
        {
            aa[lim][0] = i;
            aa[lim][1] = j;
            aa[lim++][2] = 1;
        }
    }
    if (i == j)
        return 0;
    int m = __INT_MAX__, q;
    for (int k = i; k < j; k++)
    {
        q = mcm(i, k, a, n) + mcm(k + 1, j, a, n) + a[i - 1] * a[k] * a[j];
        if (q < m)
            m = q;
    }
    return m;
}
int main()
{
    int n;
    printf("Enter no. of matrices: ");
    scanf("%d", &n);
    for (int u = 0; u < n + 1; u++)
    {
        for (int v = 0; v < 3; v++)
        {
            aa[u][v] = 0;
        }
    }
    int p[n + 1];
    printf("Enter size of the matrices: ");
    for (int i = 0; i < n + 1; i++)
    {
        scanf("%d", &p[i]);
    }
    printf("Minimum Cost : %d\n", mcm(1, n, p, n));
    printf("total no. of sub problem : %d\n", count);
    for (int j = 0; j < lim; j++)
    {
        printf("no of times of [%d,%d] is %d\n", aa[j][0], aa[j][1], aa[j][2]);
    }
}