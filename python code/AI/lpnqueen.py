from pulp import *

n = 11  # number of queens

# Create the LP problem
prob = LpProblem("nQueens", LpMinimize)

# Create the decision variables
x = LpVariable.dicts("x", [(i, j) for i in range(n) for j in range(n)], cat=LpBinary)

# Add the objective function
prob += lpSum(x[i, j] for i in range(n) for j in range(n))

# Add the row constraints
for i in range(n):
    prob += lpSum(x[i, j] for j in range(n)) == 1

# Add the column constraintspip
for j in range(n):
    prob += lpSum(x[i, j] for i in range(n)) == 1

# Add the diagonal constraints
for k in range(-n+1, n):
    prob += lpSum(x[i, j] for i in range(n) for j in range(n) if i-j == k) <= 1
    prob += lpSum(x[i, j] for i in range(n) for j in range(n) if i+j == k+n-1) <= 1

# Solve the problem
prob.solve()

# Print the solution
print("Solution:")
for i in range(n):
    for j in range(n):
        if value(x[i, j]) == 1:
            print("Q ", end="")
        else:
            print(". ", end="")
    print()