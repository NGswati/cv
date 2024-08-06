import random


def generate_population(size, num_elements):
    population = []
    for i in range(size):
        candidate = [random.randint(0, 1) for j in range(num_elements)]
        population.append(candidate)
    return population


def fitness(candidate, elements, target_sum):
    subset = [elements[i] for i in range(len(candidate)) if candidate[i] == 1]
    return abs(sum(subset) - target_sum)


def tournament_selection(population, k, elements, target_sum):
    tournament = random.sample(population, k)
    return min(tournament, key=lambda x: fitness(x, elements, target_sum))


def single_point_crossover(parent1, parent2):
    crossover_point = random.randint(1, len(parent1) - 1)
    child1 = parent1[:crossover_point] + parent2[crossover_point:]
    child2 = parent2[:crossover_point] + parent1[crossover_point:]
    return child1, child2


def mutation(candidate, probability):
    for i in range(len(candidate)):
        if random.random() < probability:
            candidate[i] = 1 - candidate[i]
    return candidate


def genetic_algorithm(elements, target_sum, population_size, num_generations, tournament_size, mutation_probability):
    population = generate_population(population_size, len(elements))
    for generation in range(num_generations):
        population_fitness = [(candidate, fitness(candidate, elements, target_sum)) for candidate in population]
        population_fitness.sort(key=lambda x: x[1])
        fittest = population_fitness[0]
        if fittest[1] == 0:
            return [elements[i] for i in range(len(fittest[0])) if fittest[0][i] == 1]
        new_population = [fittest[0]]
        while len(new_population) < population_size:
            parent1 = tournament_selection(population, tournament_size, elements, target_sum)
            parent2 = tournament_selection(population, tournament_size, elements, target_sum)
            child1, child2 = single_point_crossover(parent1, parent2)
            child1 = mutation(child1, mutation_probability)
            child2 = mutation(child2, mutation_probability)
            new_population.append(child1)
            new_population.append(child2)
        population = new_population
    return [elements[i] for i in range(len(fittest[0])) if fittest[0][i] == 1]


elements = [3, 1, 5, 9, 12]
target_sum = 18
population_size = 50
num_generations = 100
tournament_size = 5
mutation_probability = 0.1
subset = genetic_algorithm(elements, target_sum, population_size,num_generations, tournament_size, mutation_probability)
print(subset)
