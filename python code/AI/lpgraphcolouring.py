from pulp import *

def graph_coloring(num_nodes, edges, num_colors):
    # Create a PuLP LP problem instance
    prob = LpProblem("Graph Coloring Problem", LpMinimize)

    # Create a list of integer variables for each node and color combination
    nodes = LpVariable.dicts("node_color", [(i, j) for i in range(num_nodes) for j in range(num_colors)],cat="Binary")

    # Add constraints that each node must have exactly one color
    for i in range(num_nodes):
        prob += lpSum([nodes[(i, j)] for j in range(num_colors)]) == 1

    # Add constraints that adjacent nodes must have different colors
    for edge in edges:
        for j in range(num_colors):
            prob += nodes[(edge[0], j)] + nodes[(edge[1], j)] <= 1

    # Solve the problem and get the optimal solution
    prob.solve()
    if LpStatus[prob.status] == "Optimal":
        # Extract the node colors from the solution
        colors = [value(nodes[(i, j)]) for i in range(num_nodes) for j in range(num_colors)]
        colors = [colors[i*num_colors:(i+1)*num_colors].index(1) for i in range(num_nodes)]
        return colors
    else:
        return None


if __name__ == "__main__":
    num_nodes = 9
    edges = [(0, 1), (1, 2), (2, 3), (3, 0), (0, 2), (0,4),(2,4),(0,8),(8,2)]
    num_colors = 10

    colors = graph_coloring(num_nodes, edges, num_colors)
    if colors:
        print("Node colors:", colors)
    else:
        print("No valid coloring found")
