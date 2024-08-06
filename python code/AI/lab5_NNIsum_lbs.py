import random


def subset_sum_local_beam_search(numbers, target_sum, k, max_iter):
    # Generate k random subsets
    subsets = [random.sample(numbers, random.randint(
        1, len(numbers))) for _ in range(k)]
    best_state = subsets
    best_cost = sum(abs(sum(subset) - target_sum) for subset in subsets)

    for _ in range(max_iter):
        # Generate new states by merging two randomly selected states
        new_states = []
        for i in range(k):
            for j in range(i+1, k):
                new_state = subsets[:i] + [
                    list(set(subsets[i] + subsets[j]))] + subsets[i+1:j] + subsets[j+1:]
                new_states.append(new_state)

        # Evaluate the cost of each new state
        new_costs = [sum(abs(sum(subset) - target_sum) for subset in state) for state in new_states]

        # Select the k best states with the lowest cost
        all_states = subsets + new_states
        all_costs = [sum(abs(sum(subset) - target_sum) for subset in state) for state in all_states]
        sorted_indices = sorted(range(len(all_costs)),key=lambda x: all_costs[x])
        best_indices = sorted_indices[:k]
        subsets = [all_states[i] for i in best_indices]

        # Check if a better state has been found
        if all_costs[best_indices[0]] < best_cost:
            best_state = subsets
            best_cost = all_costs[best_indices[0]]

        # Terminate if a solution is found
        if best_cost == 0:
            return best_state

    # Return the best state found
    return best_state


numbers = [3, 1, 5, 2, 8, 4]
target_sum = 9
k=5
max_iter=100
subset = subset_sum_local_beam_search(numbers, target_sum, k, max_iter)
print(subset)
