from copy import deepcopy
from queue import PriorityQueue


def successors(state):
    successors = []
    row, col = next((r, c) for r, row in enumerate(state)
                    for c, val in enumerate(row) if val == 0)
    for r, c in ((row+1, col), (row-1, col), (row, col+1), (row, col-1)):
        if 0 <= r < 3 and 0 <= c < 3:
            successor = deepcopy(state)
            successor[row][col], successor[r][c] = successor[r][c], successor[row][col]
            successors.append(successor)
    return successors


def manhattan_distance(state):
    distance = 0
    for row in range(3):
        for col in range(3):
            val = state[row][col]
            if val != 0:
                r_goal, c_goal = (val-1) // 3, (val-1) % 3
                distance += abs(row - r_goal) + abs(col - c_goal)
    return distance


def dfs_branch_and_bound(state, cost_limit):
    frontier = PriorityQueue()
    visited = set()
    frontier.put((0, state))
    while not frontier.empty():
        cost, node = frontier.get()
        if node == goal_state:
            return node, cost
        if cost <= cost_limit:
            visited.add(tuple(map(tuple, node)))
            for successor in successors(node):
                if tuple(map(tuple, successor)) not in visited:
                    successor_cost = cost + 1 + manhattan_distance(successor)
                    frontier.put((successor_cost, successor))
    return None, float('inf')


initial_state = [[1, 2, 0], [4, 5, 3], [7, 8, 6]]
goal_state = [[1, 2, 3], [4, 5, 6], [7, 8, 0]]

solution, cost = dfs_branch_and_bound(initial_state, manhattan_distance(initial_state))
print("Solution: ", solution)
print("Cost: ", cost)


#Given initial state and goal state of 16 puzzle problem print the steps to reach the goal state . An optimal solution is acceptable using defth first branch and bound
# for a graph G=(V, E) a dominating set D is a subset of its vertices V that is D is subset of V such that any vertex v belongs to V is either in D or has a neighbor in D that is either v bleong to D or v does not belong to D but there exist  u,v belong to E such that u belongs to D. The objective is to obtain the smallest set  for G. Formulate the problem and solve it using local beam search   
