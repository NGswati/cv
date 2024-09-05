import heapq
import itertools


def tsp_a_star(points):
    # Calculate the distance between each pair of points
    distances = {}
    for i, p1 in enumerate(points):
        for j, p2 in enumerate(points):
            if i < j:
                distance = ((p1[0] - p2[0]) ** 2 + (p1[1] - p2[1]) ** 2) ** 0.5
                distances[(i, j)] = distance
                distances[(j, i)] = distance

    # Define the heuristic function
    def heuristic(state, remaining):
        if not remaining:
            return 0
        return min(distances[(state[-1], r)] for r in remaining)

    # Define the initial state
    initial_state = [0]
    remaining = set(range(1, len(points)))

    # Define the goal state
    goal_state = list(range(len(points)))

    # Define the frontier
    frontier = [(heuristic(initial_state, remaining),
                 0, initial_state, remaining)]
    heapq.heapify(frontier)

    # Define the explored set
    explored = set()

    # Define the cost function
    def cost(state):
        return sum(distances[(state[i], state[i+1])] for i in range(len(state)-1))

    while frontier:
        _, g, state, remaining = heapq.heappop(frontier)

        if state == goal_state:
            return state

        if tuple(state) in explored:
            continue

        explored.add(tuple(state))

        for next_node in remaining:
            new_state = state + [next_node]
            new_remaining = remaining - {next_node}
            h = heuristic(new_state, new_remaining)
            f = g + distances[(state[-1], next_node)] + h
            heapq.heappush(
                frontier, (f, g+distances[(state[-1], next_node)], new_state, new_remaining))

    return None


points = [(0, 0), (1, 1), (2, 2), (3, 3), (4, 4)]
solution = tsp_a_star(points)
print(solution)
