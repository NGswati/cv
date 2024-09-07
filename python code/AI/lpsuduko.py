# # Initialize the Sudoku grid
# grid = [    [0, 0, 0, 0, 0, 0, 0, 7, 0],
#     [0, 0, 0, 0, 0, 0, 0, 0, 0],
#     [5, 0, 0, 8, 0, 0, 4, 0, 6],
#     [0, 0, 0, 0, 0, 0, 0, 0, 3],
#     [0, 8, 0, 0, 0, 0, 0, 0, 1],
#     [0, 0, 9, 0, 0, 0, 0, 0, 0],
#     [0, 0, 0, 0, 7, 0, 0, 0, 0],
#     [0, 0, 0, 0, 0, 0, 0, 5, 0],
#     [0, 0, 0, 0, 0, 0, 8, 0, 0]
# ]
# fixed_cells = {
#     (1, 1): 5, (1, 4): 6, (1, 5): 9, (1, 7): 8, (2, 2): 6, (2, 3): 3, (2, 5): 2, (2, 6): 5,
#     (3, 1): 8, (3, 9): 7, (4, 1): 7, (4, 5): 6, (4, 9): 3, (5, 2): 9, (5, 4): 5, (5, 6): 8,
#     (5, 8): 7, (6, 2): 5, (6, 6): 2, (6, 8): 9, (7, 1): 6, (7, 9): 1, (8, 4): 8, (8, 5): 4,
#     (8, 7): 6, (8, 8): 2, (9, 3): 9, (9, 6): 4, (9, 9): 5
# }

import pulp

# Initialize the LP model
model = pulp.LpProblem("Sudoku Problem", pulp.LpMinimize)

# Define the decision variables
rows = range(1, 10)
cols = range(1, 10)
nums = range(1, 10)
vars = pulp.LpVariable.dicts("x", (rows, cols, nums), cat=pulp.LpBinary)

# Define the constraints
# Each cell can only have one number
for r in rows:
    for c in cols:
        model += pulp.lpSum([vars[r][c][n] for n in nums]) == 1

# Each row must contain each number once
for r in rows:
    for n in nums:
        model += pulp.lpSum([vars[r][c][n] for c in cols]) == 1

# Each column must contain each number once
for c in cols:
    for n in nums:
        model += pulp.lpSum([vars[r][c][n] for r in rows]) == 1

# Each 3x3 square must contain each number once
for i in range(0, 9, 3):
    for j in range(0, 9, 3):
        for n in nums:
            model += pulp.lpSum([vars[r][c][n] for r in range(i+1, i+4) for c in range(j+1, j+4)]) == 1

# Define the known values
known_values = {
    (1, 1, 5), (1, 5, 9), (1, 8, 6), (2, 2, 6), (2, 4, 2),
    (2, 6, 7), (3, 3, 8), (3, 7, 3), (4, 3, 3), (4, 7, 2),
    (5, 2, 5), (5, 5, 1), (5, 8, 7), (6, 3, 7), (6, 7, 6),
    (7, 2, 2), (7, 6, 5), (8, 4, 1), (8, 6, 3), (8, 8, 9),
    (9, 1, 8), (9, 4, 6), (9, 8, 1)
}

# Add the known values as constraints
for r, c, n in known_values:
    model += vars[r][c][n] == 1

# Solve the LP
status = model.solve()

# Print the solution
if status == pulp.LpStatusOptimal:
    for r in rows:
        if r in [1, 4, 7]:
            print("+-------+-------+-------+")
        for c in cols:
            if c in [1, 4, 7]:
                print("| ", end="")
            for n in nums:
                if pulp.value(vars[r][c][n]) == 1:
                    print(n, end=" ")
                    break
            if c == 9:
                print("|")
    print("+-------+-------+-------+")
else:
    print("No solution found.")
    
