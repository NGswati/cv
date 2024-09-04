import heapq


def dfs_bb(start_state):
    frontier = [(heuristic(start_state), 0, start_state)]
    best_cost = float('inf')
    while frontier:
        _, cost, state = heapq.heappop(frontier)
        if cost == 8:
            return state
        if cost + heuristic(state) < best_cost:
            for successor in successors(state):
                heapq.heappush(frontier, (heuristic(
                    successor) + cost + 1, cost + 1, successor))
            best_cost = cost + heuristic(state)


def successors(state):
    for col in range(8):
        for row in range(8):
            if state[row] == col:
                continue
            successor = state[:row] + [col] + state[row+1:]
            if not attacking(successor):
                yield successor


def attacking(state):
    for i in range(len(state)):
        for j in range(i+1, len(state)):
            if state[i] == state[j] or abs(state[i] - state[j]) == j - i:
                return True
    return False


def heuristic(state):
    attacks = sum(attacking(state[row:] + [0]*row) for row in range(8))
    queens = sum(1 for col in state if col == 0)
    return attacks + queens


# Example usage:
initial_state = [0, 0, 0, 0, 0, 0, 0, 0]
solution = dfs_bb(initial_state)
print(solution)
