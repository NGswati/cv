def matrix_chain_order(p):
    n = len(p) - 1
    m = [[float('inf')] * n for _ in range(n)]
    s = [[0] * n for _ in range(n)]

    for i in range(n):
        m[i][i] = 0

    for L in range(2, n+1):
        for i in range(n-L+1):
            j = i + L - 1
            for k in range(i, j):
                q = m[i][k] + m[k+1][j] + p[i]*p[k+1]*p[j+1]
                if q < m[i][j]:
                    m[i][j] = q
                    s[i][j] = k

    return m, s


def print_optimal_parens(s, i, j):
    if i == j:
        print(f"A{i+1}", end='')
    else:
        print("(", end='')
        print_optimal_parens(s, i, s[i][j])
        print_optimal_parens(s, s[i][j]+1, j)
        print(")", end='')

#[1,2,15,5,10,20,25]

p = [1, 2, 15, 5, 10, 20, 25]
m, s = matrix_chain_order(p)
print("Minimum number of scalar multiplications:", m[0][len(p)-2])
print("Optimal parenthesization:", end=' ')
print_optimal_parens(s, 0, len(p)-2)
print("\n")


