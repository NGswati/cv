import random


def subset_sum(numbers, target):
    # Define the initial state as a random subset of the given set
    current_subset = set(random.sample(
        numbers, random.randint(1, len(numbers))))
    # Calculate the difference between the sum of the current subset and the target sum
    current_difference = abs(sum(current_subset) - target)
    while True:
        # Generate all possible successors of the current subset by adding or removing an element
        successors = []
        for number in numbers:
            if number not in current_subset:
                successors.append(current_subset.union(set([number])))
            elif len(current_subset) > 1:
                successors.append(current_subset.difference(set([number])))
        # If there are no successors, return the current subset
        if not successors:
            return current_subset
        # Calculate the heuristic for each successor and select the one with the smallest difference
        best_successor = None
        best_difference = float('inf')
        for successor in successors:
            difference = abs(sum(successor) - target)
            if difference < best_difference:
                best_difference = difference
                best_successor = successor
        # If the best successor is not better than the current subset, return the current subset
        if best_difference >= current_difference:
            return current_subset
        # Update the current subset and difference with the best successor
        current_subset = best_successor
        current_difference = best_difference


numbers = [3, 1, 5, 9, 12]
target_sum = 14
subset = subset_sum(numbers, target_sum)
print(subset) 