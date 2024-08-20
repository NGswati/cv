'''======================================Ques1=========================================='''
# from queue import PriorityQueue
# import random


# def successors(state):
   
#     successors = []
#     # row, col = next((r, c) for r, row in enumerate(state) for c, val in enumerate(row) if val == 0)
#     # for r, c in ((row+1, col), (row-1, col), (row, col+1), (row, col-1)):
#     #     if 0 <= r < 4 and 0 <= c < 4:
#     # successor = deepcopy(state)
#     #         successor[row][col], successor[r][c] = successor[r][c], successor[row][col]
#     i = [[12, 1, 2, 15], [11, 6, 5, 8], [0, 13, 14, 3],  [7, 10, 9, 4]]
#     successors.append(i)
#     k=random.randint(0,2)
#     i[k],i[k+1]=i[k+1],i[k]
#     print(state)
   
#     successors.append(i)
#     return successors


# def manhattan_distance(state):
#     distance = 0
#     for row in range(4):
#         for col in range(4):
#             val = state[row][col]
#             if val != 0:
#                 r_goal, c_goal = (val-1) // 4, (val-1) % 4
#                 distance += abs(row - r_goal) + abs(col - c_goal)
#     return distance


# def astar_search(initial_state, goal_state):
#     frontier = PriorityQueue()
#     visited = set()
#     frontier.put((manhattan_distance(initial_state), 0, initial_state))
#     while not frontier.empty():
#         f, cost, node = frontier.get()
#         # print(node)
#         if node == goal_state:
#             return node, cost
#         visited.add(tuple(map(tuple, node)))
#         for successor in successors(node):
#             if tuple(map(tuple, successor)) not in visited:
#                 successor_cost = cost + 1 + manhattan_distance(successor)
#                 frontier.put((successor_cost, cost + 1, successor))
#     return None, float('inf')


# # initial_state = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 0, 11], [13, 14, 15, 12]]
# # goal_state = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 0]]
# initial_state = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 0]]
# goal_state = [[12, 1, 2, 15], [11, 6, 5, 8], [7, 10, 9, 4], [0, 13, 14, 3]]

# solution, cost = astar_search(initial_state, goal_state)
# print("Solution: ", solution)
# print("Cost: ", cost)



'''======================================Ques2=========================================='''
import random
import networkx as nx



def generate_initial_population(graph, population_size):
    population = []
    for i in range(population_size):
        solution = set()
        for node in graph.nodes:
            if random.random() < 0.5:
                solution.add(node)
        population.append(solution)
    return population


def evaluate_fitness(solution, graph):
    covered = set()
    for node in solution:
        covered.add(node)
        for neighbor in graph.neighbors(node):
            covered.add(neighbor)
    return len(covered)


def selection(population, graph):
    population_fitness = [evaluate_fitness(solution, graph) for solution in population]
    total_fitness = sum(population_fitness)
    probabilities = [fitness / total_fitness for fitness in population_fitness]
    selected = random.choices(population, probabilities, k=len(population))
    return selected


def crossover(parent1, parent2):
    child1 = set(random.sample(parent1, len(parent1) // 2))
    child2 = set(random.sample(parent2, len(parent2) // 2))
    child = child1.union(child2)
    return child


def mutation(solution, graph, mutation_rate):
    for node in graph.nodes:
        if node in solution and random.random() < mutation_rate:
            solution.remove(node)
        elif node not in solution and random.random() < mutation_rate:
            solution.add(node)
    return solution


def genetic_algorithm(graph, population_size, mutation_rate, max_generations):
    population = generate_initial_population(graph, population_size)
    best_solution = None
    for generation in range(max_generations):
        selected = selection(population, graph)
        offspring = []
        for i in range(len(population)):
            parent1 = random.choice(selected)
            parent2 = random.choice(selected)
            child = crossover(parent1, parent2)
            child = mutation(child, graph, mutation_rate)
            offspring.append(child)
        population = offspring
        best_fitness = float('inf')
        for solution in population:
            fitness = evaluate_fitness(solution, graph)
            if fitness < best_fitness:
                best_fitness = fitness
                best_solution = solution
        print(f"Generation {generation}: Best fitness = {best_fitness}")
    return best_solution, best_fitness


n = int(input("Enter the number of nodes: "))
graph = nx.Graph()

for i in range(n):
    graph.add_node(i)

while True:
    edge = input("Enter an edge (u v), or 'done' to finish: ")
    if edge == "done":
        break
    u, v = map(int, edge.split())
    graph.add_edge(u, v)


# graph = nx.gnp_random_graph(n, 0.2)
population_size = 10
mutation_rate = 0.5
max_generations = 10
dominating_set, fitness = genetic_algorithm(graph, population_size, mutation_rate, max_generations)
print("Dominating set:", dominating_set)
print("Fitness:", fitness)
print("\nGraph:")
print(nx.adjacency_matrix(graph))
