import heapq


def manhattan_distance(state):
    n = int(len(state) ** 0.5)
    dist = 0
    for i in range(n):
        for j in range(n):
            value = state[n*i + j]
            if value != 0:
                row = (value - 1) // n
                col = (value - 1) % n
                dist += abs(row - i) + abs(col - j)
    return dist


def misplaced_tiles(state):
    count = 0
    for i in range(len(state)):
        if state[i] != i:
            count += 1
    return count


def goal_test(state):
    return state == [12, 1, 2, 15, 11, 6, 5, 8, 7, 10, 9, 4, 0, 13, 14, 3]


def get_successors(state):
    successors = []
    n = int(len(state) ** 0.5)
    blank_index = state.index(0)
    row, col = blank_index // n, blank_index % n

    for i, j in [(row-1, col), (row, col-1), (row, col+1), (row+1, col)]:
        if 0 <= i < n and 0 <= j < n:
            new_state = state[:]
            index = i * n + j
            new_state[blank_index], new_state[index] = new_state[index], new_state[blank_index]
            successors.append(new_state)
    return successors


def astar_search(start_state, heuristic):
    frontier = [(0, start_state)]
    visited = set()
    g_score = {tuple(start_state): 0}
    f_score = {tuple(start_state): heuristic(start_state)}

    while frontier:
        _, state = heapq.heappop(frontier)
        if goal_test(state):
            return state, len(visited)

        visited.add(tuple(state))
        for successor in get_successors(state):
            if tuple(successor) in visited:
                continue
            new_g_score = g_score[tuple(state)] + 1
            if tuple(successor) not in g_score or new_g_score < g_score[tuple(successor)]:
                g_score[tuple(successor)] = new_g_score
                f_score[tuple(successor)] = new_g_score + heuristic(successor)
                heapq.heappush(
                    frontier, (f_score[tuple(successor)], successor))

    return None, len(visited)


# Example usage:
start_state = [1, 2, 3, 4, 0, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0]
manhattan_solution, manhattan_expanded = astar_search(start_state, manhattan_distance)
misplaced_tiles_solution, misplaced_tiles_expanded = astar_search(start_state, misplaced_tiles)

print("A* with Manhattan distance: Solution: ", manhattan_solution)
print("A* with Manhattan distance: Number of expanded nodes: ", manhattan_expanded)
print("A* with misplaced tiles: Solution: ", misplaced_tiles_solution)
print("A* with misplaced tiles: Number of expanded nodes: ",misplaced_tiles_expanded)
