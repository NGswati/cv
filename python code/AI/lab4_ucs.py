import heapq

def ucs(start_state):
    frontier = [(0, start_state)]
    explored = set()
    while frontier :
        print(frontier)
        cost, state = heapq.heappop(frontier)
        if cost == 8 or not attacking(state):
            return state
        explored.add(tuple(state))
    
        successor = successors(state)
        if tuple(successor) not in explored:
            heapq.heappush(frontier, (cost + 1, successor))

def successors(state):
    for col in range(8):
        for row in range(8):
            if state[row] == col:
                continue
            successor = state[:row] + [col] + state[row+1:]
            return successor

def attacking(state):
    for i in range(len(state)):
        for j in range(i+1, len(state)):
            if state[i] == state[j] or abs(state[i] - state[j]) == j - i:
                return True
    return False

# Example usage:
initial_state = [0, 0, 0, 0, 0, 0, 0, 0]
solution = ucs(initial_state)
print(solution)
