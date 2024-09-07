from z3 import *
from itertools import combinations


x1, x2, x3, x4, x5, x6 = Bools('x1 x2 x3 x4 x5 x6')
# x1=Bool(input("x1: "))
# x2=Bool(input("x2: "))
# x3=Bool(input("x3: "))
# x4=Bool(input("x4: "))
# x5=Bool(input("x5: "))
# x6=Bool(input("x6: "))
expr = And(Or(x1, Not(x2), x3), Or(x2, Not(x3), x4), Or(Not(x2) , Not(x3) , x4), Or(x3, Not(x4), Not(x5)), Or(x1, x5, x6))


solver = Solver()
solver.add(expr)


if solver.check() == sat:

    model = solver.model()
 
    print("Satisfying assignment:")
    for v in (x1, x2, x3, x4, x5, x6):
        print(f"{v} = {model[v]}")
else:
    print("The expression is unsatisfiable.")




# Integer Linear Programming


# min :1;
# x1+1-x2+x3=1;
# x2+1-x3+x4=1;
# 1-x2+1-x3+x4=1;
# x3+1-x4+1-x5=1;
# x1+x5+x6=1;

from pulp import *


formula = [
    [1, -2, 3],  # (x1 or ~x2 or x3)
    [2, -3, 4],  # (x2 or ~x3 or x4)
    [-2, -3, 4], # (~x2 or ~x3 or x4)
    [3, -4, -5], # (x3 or ~x4 or ~x5)
    [1, 5, 6],   # (x1 or x5 or x6)
]

model = LpProblem("3-SAT", LpMaximize)

x1 = LpVariable("x1", lowBound=0, upBound=1, cat="Integer")
x2 = LpVariable("x2", lowBound=0, upBound=1, cat="Integer")
x3 = LpVariable("x3", lowBound=0, upBound=1, cat="Integer")
x4 = LpVariable("x4", lowBound=0, upBound=1, cat="Integer")
x5 = LpVariable("x5", lowBound=0, upBound=1, cat="Integer")
x6 = LpVariable("x6", lowBound=0, upBound=1, cat="Integer")

c1 = LpVariable("c1", lowBound=0, upBound=1, cat="Integer")
c2 = LpVariable("c2", lowBound=0, upBound=1, cat="Integer")
c3 = LpVariable("c3", lowBound=0, upBound=1, cat="Integer")
c4 = LpVariable("c4", lowBound=0, upBound=1, cat="Integer")
c5 = LpVariable("c5", lowBound=0, upBound=1, cat="Integer")

model += x1 <= 1
model += x2 <= 1
model += x3 <= 1
model += x4 <= 1
model += x5 <= 1
model += x6 <= 1

model += c1 == (x1 + (1 - x2) + x3 - 1)
model += c2 == (x2 + (1 - x3) + x4 - 1)
model += c3 == ((1 - x2) + (1 - x3) + x4 - 1)
model += c4 == (x3 + (1 - x4) + (1 - x5) - 1)
model += c5 == (x1 + x5 + x6 - 1)

model += c1 + c2 + c3 + c4 + c5 >= 1

model.solve()

if model.status == LpStatusOptimal:
    print("ILP solution:")
    print(f"x1 = {int(value(x1))}")
    print(f"x2 = {int(value(x2))}")
    print(f"x3 = {int(value(x3))}")
    print(f"x4 = {int(value(x4))}")
    print(f"x5 = {int(value(x5))}")
    print(f"x6 = {int(value(x6))}")

    if (int(value(x1)) or not int(value(x2)) or int(value(x3))) \
        and (int(value(x2)) or not int(value(x3)) or int(value(x4))) \
        and (not int(value(x2)) or not int(value(x3)) or int(value(x4))) \
        and (int(value(x3)) or not int(value(x4)) or not int(value(x5))) \
        and (int(value(x1)) or int(value(x5)) or int(value(x6))):
        print("Boolean formula is satisfiable")
    else:
        print("Boolean formula is unsatisfiable")
else:
    print("No feasible solution")

#Question 2

import pulp

profit =[[8,4,2,6,1,],[0,9,5,5,4],[3,8,9,2,6],[4,3,1,0,3],[9,5,8,9,5]]

prob = pulp.LpProblem("Task Assignment Problem", pulp.LpMaximize)

agents = range(5)
tasks = range(5)
x = pulp.LpVariable.dicts("x", [(i, j) for i in tasks for j in agents], cat="Binary")

prob += pulp.lpSum([x[(i, j)] * profit[i][j] for i in tasks for j in agents])# maximize

for i in tasks:
    prob += pulp.lpSum([x[(i, j)] for j in agents]) <= 1

for j in agents:
    prob += pulp.lpSum([x[(i, j)] for i in tasks]) <= 1

prob.solve()

print("Optimal solution:")
for i in tasks:
    for j in agents:
        if x[(i, j)].value() == 1:
            print(f"Assign task {i+1} to agent {j+1}")
print(f"Total profit: {pulp.value(prob.objective)}")






