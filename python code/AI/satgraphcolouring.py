from z3 import *


def graph_coloring(num_nodes, edges, num_colors):
    # Create a solver instance
    solver = Solver()

    # Create a list of boolean variables for each node and color combination
    nodes = [Bool(f"node{i}_color{j}")
             for i in range(num_nodes) for j in range(num_colors)]

    # Add constraints that each node must have exactly one color
    for i in range(num_nodes):
        exactly_one_color = Or([nodes[i*num_colors+j]for j in range(num_colors)])
        solver.add(exactly_one_color)

    # Add constraints that adjacent nodes must have different colors
    for edge in edges:
        for j in range(num_colors):
            solver.add(Implies(nodes[edge[0]*num_colors+j],
                       Not(nodes[edge[1]*num_colors+j])))

    # Check if there is a satisfying assignment
    if solver.check() == sat:
        # Get the model and extract the node colors
        model = solver.model()
        colors = []
        for i in range(num_nodes):
            for j in range(num_colors):
                if is_true(model.evaluate(nodes[i*num_colors+j])):
                    colors.append(j)
                    break
        return colors
    else:
        return None


if __name__ == "__main__":
    num_nodes = 6
    edges = [(0, 1), (1, 2), (2, 3), (3, 0),(0,2),(1,3)]
    num_colors = num_nodes

    colors = graph_coloring(num_nodes, edges, num_colors)
    if colors:
        print("Node colors:", colors)
    else:
        print("No valid coloring found")
