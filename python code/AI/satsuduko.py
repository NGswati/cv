from z3 import *
from itertools import combinations
# 9X9 grid
# if x[i][j][k] is true iff cell i,j has value (k+1)
# each numbr appears only once in each row/col/box
# constrainsts of the type exactly once..


def exactly_once(literals):
    c = []
    for pair in combinations(literals, 2):
        a, b = pair[0], pair[1]
        c += [Or(Not(a), Not(b))]
    c += [Or(literals)]
    return And(c)
# define the literals
# Suduko 9X9
# for every cell 9 digits
# 9X9X9 Literals


def print_solution(model, lits):
    lines = []
    for i in range(9):
        lines += [[]]
        for j in range(9):
            digit = 0
            for x in range(9):
                if model.evaluate(lits[i][j][x]):
                    digit = x+1
            lines[i] += [digit]
    for line in lines:
        print(" ".join([str(x) for x in line]))


def solve(grid):
    lits = []
    for i in range(9):
        lits += [[]]
        for j in range(9):
            lits[i] += [[]]
            for digit in range(9):
                lits[i][j] += [Bool("x_%i_%i_%i" % (i, j, digit))]

    s = Solver()
    # only one possible value per cell
    for i in range(9):
        for j in range(9):
            s.add(exactly_once(lits[i][j]))

    # each value should be used only once per row
    for i in range(9):
        for x in range(9):
            row = []
            for j in range(9):
                row += [lits[i][j][x]]
            s.add(exactly_once(row))

    # each value should be used only once per col
    for j in range(9):
        for x in range(9):
            row = []
            for i in range(9):
                row += [lits[i][j][x]]
            s.add(exactly_once(row))

    # each value should be used only once in each subgrid
    # for each 3X3 sub grid
    for i in range(3):
        for j in range(3):
            for k in range(9):
                grid_cells = []
                for x in range(3):
                    for y in range(3):
                        grid_cells += [lits[3*i + x][3*j + y][k]]
                s.add(exactly_once(grid_cells))

    # now assume grid[][] represents the values in the grid
    # 0 means there is no value
    # we add the constraints
    for i in range(9):
        for j in range(9):
            if grid[i][j] > 0:
                s.add(lits[i][j][grid[i][j]-1])

    if str(s.check()) == 'sat':
        print_solution(s.model(), lits)
    else:
        print("unsat")


if __name__ == "__main__":
    filename = "grid.txt"
    grid = []
    with open(filename, 'r') as input_f:
        for line in input_f.readlines():
            x = line.split(" ")
            if line.strip():
                grid.append([int(x) for x in line.split()])
        solve(grid)
        exit(0)
