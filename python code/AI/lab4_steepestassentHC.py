import random


def hill_climbing():
    current_state = [random.randint(0, 7) for i in range(8)]
    while True:
        attacks = sum(1 for i in range(8) for j in range(
            i+1, 8) if current_state[i] == current_state[j] or abs(current_state[i] - current_state[j]) == j - i)
        if attacks == 0:
            return current_state
        neighbors = []
        for i in range(8):
            for j in range(8):
                if current_state[i] != j:
                    neighbor = current_state.copy()
                    neighbor[i] = j
                    neighbors.append(neighbor)
        if not neighbors:
            return current_state
        neighbor_attacks = [(sum(1 for i in range(8) for j in range(i+1, 8) if neighbor[i] == neighbor[j]
                             or abs(neighbor[i] - neighbor[j]) == j - i), neighbor) for neighbor in neighbors]
        best_attacks, best_neighbor = min(neighbor_attacks)
        if best_attacks >= attacks:
            return current_state
        current_state = best_neighbor


# Example usage:
solution = hill_climbing()
print(solution)
