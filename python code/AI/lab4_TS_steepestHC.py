import random


def tsp_steepest_ascent_hill_climbing(D, s):
    # Generate a random initial tour
    tour = list(range(1, len(D)))
    random.shuffle(tour)
    tour = [s] + tour + [s]

    # Calculate the total distance of the initial tour
    dist = tour_distance(tour, D)

    while True:
        # Generate a list of all possible neighboring tours
        neighbors = []
        for i in range(1, len(tour)-1):
            for j in range(i+1, len(tour)-1):
                neighbor = tour[:]
                neighbor[i], neighbor[j] = neighbor[j], neighbor[i]
                neighbors.append(neighbor)

        # Calculate the total distance of each neighboring tour
        neighbor_dists = [tour_distance(neighbor, D) for neighbor in neighbors]

        # Find the neighboring tour with the shortest total distance
        best_neighbor_idx = min(range(len(neighbors)),
                                key=lambda i: neighbor_dists[i])
        best_neighbor = neighbors[best_neighbor_idx]
        best_neighbor_dist = neighbor_dists[best_neighbor_idx]

        # If the best neighboring tour has a shorter total distance, update the current tour
        if best_neighbor_dist < dist:
            tour = best_neighbor
            dist = best_neighbor_dist
        else:
            break

    return tour, dist


def tour_distance(tour, D):
    dist = 0
    for i in range(len(tour)-1):
        dist += D[tour[i]][tour[i+1]]
    return dist


# Example usage:
D = [[0, 2, 9, 10, 5],
     [2, 0, 6, 4, 3],
     [9, 6, 0, 8, 7],
     [10, 4, 8, 0, 1],
     [5, 3, 7, 1, 0]]
s = 0
tour, dist = tsp_steepest_ascent_hill_climbing(D, s)
print("Shortest tour:", tour)
print("Shortest distance:", dist)
