from z3 import *
from itertools import combinations
# encode a problem into SAT solver
# constraints :
# place 4 queens such taht no two queens are on the same row, same col and same diagonal
# place 5 queens - atleast 5 queens should be true
# literals x1...xn

n=11
def atmost_one(literals):  # encoding of atmost one const
    c = []
    for pair in combinations(literals, 2):
        a, b = pair[0], pair[1]
        c += [Or(Not(a), Not(b))]
    return And(c)


# create all boolean literals
x = [[Bool("x_%i_%i" % (i, j)) for j in range(n)] for i in range(n)]

# create solver instance
s = Solver()

# atleast 5 queens
for i in range(n):
    s.add(Or(x[i]))

# atmost one queen per row
for i in range(n):
    col = []
    for j in range(n):
        col += [x[j][i]]
    s.add(atmost_one(col))
    s.add(atmost_one(x[i]))

# checking diagonal values
for i in range(4):
    diag_1 = []
    diag_2 = []
    diag_3 = []
    diag_4 = []
    for j in range(n - i):
        diag_1 += [x[i+j][j]]
        diag_2 += [x[i+j][n-1-j]]
        diag_3 += [x[n-1-(i+j)][j]]
        diag_4 += [x[n-1 - (i+j)][n-1-j]]
    s.add(atmost_one(diag_1))
    s.add(atmost_one(diag_2))
    s.add(atmost_one(diag_3))
    s.add(atmost_one(diag_4))

print(s.check())
m = s.model()
for i in range(n):
    line = ""
    for j in range(n):
        if m.evaluate(x[i][j]):
            line += "x "
        else:
            line += "- "
    print(line)
