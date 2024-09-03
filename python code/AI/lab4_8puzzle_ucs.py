import heapq


def manhattan_distance(state):
    """
    Calculate the Manhattan distance heuristic for a given state of the 8-puzzle problem
    """
    distance = 0
    for i in range(3):
        for j in range(3):
            if state[i][j] != 0:
                # calculate the distance of the current tile from its goal position
                goal_i, goal_j = (state[i][j] - 1) // 3, (state[i][j] - 1) % 3
                distance += abs(i - goal_i) + abs(j - goal_j)
    return distance


def successors(state):
    """
    Generate all possible successor states of a given state of the 8-puzzle problem
    """
    successors = []
    blank_i, blank_j = next((i, j) for i in range(3)for j in range(3) if state[i][j] == 0)
    for move_i, move_j in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
        new_i, new_j = blank_i + move_i, blank_j + move_j
        if 0 <= new_i < 3 and 0 <= new_j < 3:
            new_state = [row[:] for row in state]
            new_state[blank_i][blank_j], new_state[new_i][new_j] = new_state[new_i][new_j], new_state[blank_i][blank_j]
            successors.append(new_state)
    return successors


def ucs(start_state):
    """
    Solve the 8-puzzle problem using Uniform Cost Search algorithm with Manhattan distance heuristic
    """
    frontier = [(0, start_state)]
    visited = set()
    while frontier:
        cost, state = heapq.heappop(frontier)
        if state == goal_state:
            return state
        visited.add(tuple(map(tuple, state)))
        for successor in successors(state):
            if tuple(map(tuple, successor)) not in visited:
                heapq.heappush(frontier, (cost + 1, successor))
    return None


# Test the algorithm with the following initial state and goal state
start_state = [[2, 8, 3], [1, 6, 4], [7, 0, 5]]
goal_state = [[1, 2, 3], [4, 5, 6], [7, 8, 0]]

# Solve the problem using UCS algorithm with Manhattan distance heuristic
solution_state = ucs(start_state)

# Print the solution state
if solution_state:
    print("Solution found!")
    for row in solution_state:
        print(row)
else:
    print("No solution found.")

# import heapq
# import copy


# def successors(state):
#     """Generate possible moves from the current state."""
#     moves = []
#     x, y = next((i, j) for i in range(3) for j in range(3) if state[i][j] == 0)
#     for dx, dy in ((0, 1), (0, -1), (1, 0), (-1, 0)):
#         if 0 <= x + dx < 3 and 0 <= y + dy < 3:
#             new_state = copy.deepcopy(state)
#             new_state[x][y], new_state[x+dx][y +dy] = new_state[x+dx][y+dy], new_state[x][y]
#             moves.append(new_state)
#     return moves


# def manhattan_distance(state):
#     """Calculate the Manhattan distance heuristic."""
#     distance = 0
#     for i in range(3):
#         for j in range(3):
#             value = state[i][j]
#             if value != 0:
#                 goal_x, goal_y = (value-1) // 3, (value-1) % 3
#                 distance += abs(i - goal_x) + abs(j - goal_y)
#     return distance


# def ucs(initial_state):
#     """Solve the 8-puzzle problem using UCS with Manhattan distance heuristic."""
#     visited = set()
#     frontier = [(0, initial_state)]
#     while frontier:
#         cost, state = heapq.heappop(frontier)
#         if state == goal_state:
#             return cost
#         print(tuple(state), state, tuple(tuple(state[0])+tuple(state[1])+tuple(state[2])))
#         if tuple(tuple(state[0])+tuple(state[1])+tuple(state[2])) in visited:
#             continue
#         visited.add(state)
#         for successor in successors(state):
#             if tuple(successor) not in visited:
#                 heapq.heappush(frontier, (cost + 1, successor))
#     return None


# # main
# initial_state = [[1, 2, 3], [4, 0, 5], [6, 7, 8]]
# goal_state = [[1, 2, 3], [4, 5, 6], [7, 8, 0]]
# cost = ucs(initial_state)
# print(cost)


# def misplaced_tiles(state):
#     """Calculate the number of misplaced tiles heuristic."""
#     count = 0
#     for i in range(3):
#         for j in range(3):
#             if state[i][j] != goal_state[i][j]:
#                 count += 1
#     return count



