# # from queue import PriorityQueue

# # class Node:
# #     def __init__(self, state, cost, heuristic):
# #         self.state = state
# #         self.cost = cost
# #         self.heuristic = heuristic
# #         self.f = self.cost + self.heuristic

# #     def __lt__(self, other):
# #         return self.f < other.f


# # def tower_of_hanoi(n, start, dest, other):
# #     start_state = [list(range(n, 0, -1)), [], []]
# #     goal_state = [[], [], list(range(n, 0, -1))]
# #     def h(state): return sum(len(state[i]) * (i+1) for i in range(3))
# #     root = Node(start_state, 0, h(start_state))
# #     open_list = PriorityQueue()
# #     open_list.put(root)
# #     pppp=0
# #     while not open_list.empty():
# #         print(pppp)
# #         pppp=pppp+1

# #         curr_node = open_list.get()
# #         curr_state = curr_node.state
# #         if curr_state == goal_state:
# #             return curr_node.cost
# #         for i in range(3):
# #             if len(curr_state[i]) == 0:
# #                 continue
# #             for j in range(3):
# #                 if i == j:
# #                     continue
# #                 if len(curr_state[j]) == 0 or curr_state[i][-1] < curr_state[j][-1]:
# #                     child_state = [curr_state[k].copy() for k in range(3)]
# #                     child_state[j].append(child_state[i].pop())
# #                     child_cost = curr_node.cost + 1
# #                     child_heuristic = h(child_state)
# #                     child_node = Node(child_state, child_cost, child_heuristic)
# #                     open_list.put(child_node)
# #     return None


# # # Example usage
# # n = 4  # number of disks
# # start = 0  # index of starting peg
# # dest = 2  # index of destination peg
# # other = 1  # index of the other peg
# # moves = tower_of_hanoi(n, start, dest, other)
# # if moves is not None:
# #     print(f"Minimum moves required: {moves}")
# # else:
# #     print("No solution found")


# from typing import List, Tuple
# import heapq


# class State:
#     def __init__(self, disks: List[List[int]], source: int, dest: int, cost: int):
#         self.disks = disks  # list of three lists representing the three pe
#         self.source = source  # index of the source peg (0, 1, or 2)
#         self.dest = dest  # index of the destination peg (0, 1, or 2)
#         self.cost = cost  # total cost of the state

#     def __lt__(self, other):
#         return self.cost < other.cost

#     def __eq__(self, other):
#         return self.disks == other.disks and self.source == other.source and self.dest == other.dest

#     def __hash__(self):
#         return hash(str(self.disks) + str(self.source) + str(self.dest))


# def print_state(state: State):
#     print(f"Source: {state.source}, Destination: {state.dest}")
#     print("Pegs:")
#     for peg in state.disks:
#         print(peg)


# def expand(state: State) -> List[State]:
#     result = []
#     for i, peg in enumerate(state.disks):
#         if len(peg) > 0:
#             for j, other_peg in enumerate(state.disks):
#                 if i != j and (len(other_peg) == 0 or peg[-1] < other_peg[-1]):
#                     new_disks = [list(p) for p in state.disks]
#                     new_disks[j].append(new_disks[i].pop())
#                     new_state = State(new_disks, i, j, state.cost + 1)
#                     result.append(new_state)
#     return result


# def a_star(start: State, goal: State) -> Tuple[State, int]:
#     closed_set = set()
#     open_set = [start]
#     heapq.heapify(open_set)
#     parents = {}  # dictionary mapping states to their parent states
#     while open_set:
#         current = heapq.heappop(open_set)
#         if current == goal:
#             # construct the path from start to goal using parents
#             path = [current]
#             while path[-1] != start:
#                 path.append(parents[path[-1]])
#             path.reverse()
#             return current, current.cost, path
#         closed_set.add(current)
#         for neighbor in expand(current):
#             if neighbor in closed_set:
#                 continue
#             neighbor.cost += heuristic(neighbor)
#             heapq.heappush(open_set, neighbor)
#             # record the parent of the neighbor state
#             parents[neighbor] = current
#     return None, -1, []


# def tower_of_hanoi(n: int, source: int, dest: int) -> Tuple[List[List[int]], int]:
#     start = State([list(range(n, 0, -1)), [], []], source, dest, 0)
#     goal = State([[], [], list(range(n, 0, -1))], source, dest, 0)
#     solution, cost, path = a_star(start, goal)
#     if solution is None:
#         return None, -1
#     print(
#         f"Solution with {n} disks, moving from peg {source+1} to peg {dest+1}, cost {cost}")
#     for state in path:
#         print_state(state)
#     return solution.disks, cost


# def heuristic(state: State) -> int:
#     # simple heuristic that returns the number of disks not in the destination peg
#     return sum(len(peg) for i, peg in enumerate(state.disks) if i != state.dest)


# disks = 5
# source = 0
# dest = 2
# print()
# solution, cost = tower_of_hanoi(disks, source, dest)
# print(
#     f"Solution with {disks} disks, moving from peg {source+1} to peg {dest+1}, cost {cost}")
# print(solution)

# write code for the following
# Design a min/max game tree with alpha- beta pruning for the game the description of game is as follows:
#     it is a 2-player game 
#     there is a heap of sicks on a board say n (where n is given externally)
#     each player picks up sticks alternatively 
#     on their turn each player has to pick at least 1 stick and he can pick at most 3 sticks 
#     the one who has to pick the final stick will be the loser
#     first turn will  be randomly decided with the toss
# you need to design the following 
# 1. design the game for n=53
# 2. design AI vs human game 
    
    
import math
import random
import copy

# Define the game class


class Game:
    def __init__(self, n):
        self.n = n
        self.current_player_index = None
        self.winner = None

    # Determine the valid actions for the current state
    def actions(self):
        actions = []
        for i in range(1, 4):
            if i <= self.n:
                actions.append(i)
        return actions

    # Update the state of the game given an action
    def update(self, action):
        self.n -= action
        if self.n == 0:
            self.winner = self.current_player_index

    # Determine if the game is over
    def is_over(self):
        return self.winner is not None

    # Determine the utility of the final game state
    def utility(self, player_index):
        if self.winner == player_index:
            return 1
        elif self.winner is None:
            return 0
        else:
            return -1

    # Determine the current player
    def current_player(self):
        if self.current_player_index is None:
            self.current_player_index = math.floor(random.random() * 2)
        return self.current_player_index

    # Switch to the other player
    def switch_player(self):
        self.current_player_index = 1 - self.current_player_index

# Define the minimax function with alpha-beta pruning


def minimax(game, player_index, alpha, beta):
    if game.is_over():
        return game.utility(player_index), None

    if game.current_player() == player_index:
        best_value = -math.inf
        best_action = None
        for action in game.actions():
            game_copy = copy.deepcopy(game)
            game_copy.update(action)
            value, _ = minimax(game_copy, player_index, alpha, beta)
            if value > best_value:
                best_value = value
                best_action = action
            alpha = max(alpha, best_value)
            if beta <= alpha:
                break
        return best_value, best_action

    else:
        best_value = math.inf
        best_action = None
        for action in game.actions():
            game_copy = copy.deepcopy(game)
            game_copy.update(action)
            value, _ = minimax(game_copy, player_index, alpha, beta)
            if value < best_value:
                best_value = value
                best_action = action
            beta = min(beta, best_value)
            if beta <= alpha:
                break
        return best_value, best_action


# Initialize the game
game = Game(6)

# Play the game against the AI
while not game.is_over():
    if game.current_player() == 0:
        print("Your turn. There are", game.n, "sticks on the board.")
        action = int(input("How many sticks do you want to pick up? "))
        while action < 1 or action > 3 or action > game.n:
            action = int(
                input("Invalid input. How many sticks do you want to pick up? "))
        game.update(action)
    else:
        print("AI's turn. There are", game.n, "sticks on the board.")
        value, action = minimax(game, 1, -math.inf, math.inf)
        print("AI picks up", action, "sticks.")
        game.update(action)

# Determine the winner
if game.utility(0) == 1:
    print("Congratulations! You won!")
else:
    print("Damn! AI wins")
