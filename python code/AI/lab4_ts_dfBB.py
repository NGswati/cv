import heapq
import itertools


def tsp_dfs_bb(points):
    # Calculate the distance between each pair of points
    distances = {}
    for i, p1 in enumerate(points):
        for j, p2 in enumerate(points):
            if i < j:
                distance = ((p1[0] - p2[0]) ** 2 + (p1[1] - p2[1]) ** 2) ** 0.5
                distances[(i, j)] = distance
                distances[(j, i)] = distance

    # Define the initial state
    initial_state = (0, [0], set(range(1, len(points))))

    # Define the goal state
    goal_state = (float('inf'), None)

    # Define the cost function
    def cost(state):
        return sum(distances[(state[1][i], state[1][i+1])] for i in range(len(state[1])-1))

    def successors(state):
        _, path, remaining = state
        for next_node in remaining:
            new_path = path + [next_node]
            new_remaining = remaining - {next_node}
            yield (cost((0, new_path, new_remaining)), new_path, new_remaining)

    def bound(state):
        _, path, remaining = state
        if not remaining:
            return cost((0, path, set(range(len(points)))))
        return cost((0, path, remaining)) + min(distances[(path[-1], node)] for node in remaining)

    def dfs_bb(state):
        nonlocal goal_state
        if not state[2]:
            goal_state = min(goal_state, (cost(state), state[1]))
        else:
            for child in sorted(successors(state)):
                if child[0] < goal_state[0]:
                    if bound(child) < goal_state[0]:
                        dfs_bb(child)

    dfs_bb(initial_state)

    return goal_state[1]


points = [(0, 0), (1, 1), (2, 2), (3, 3), (4, 4)]
solution = tsp_dfs_bb(points)
print(solution)
