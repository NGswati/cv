import math
import random
import copy


class Game:
    def __init__(self, n):
        self.n = n
        self.current_player_index = None
        self.winner = None

    def actions(self):
        actions = []
        for i in range(1, 4):
            if i <= self.n:
                actions.append(i)
        return actions

    def update(self, action):
        self.n -= action
        if self.n == 0:
            self.winner = self.current_player_index

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

    def current_player(self):
        if self.current_player_index is None:
            self.current_player_index = math.floor(random.random() * 2)
        return self.current_player_index

    def switch_player(self):
        self.current_player_index = 1 - self.current_player_index

                                             
def minimax(game, player_index, alpha, beta):  # minimax function with alpha-beta pruning
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


print("\n\t\t\t\t\t\tThe game of Sticks")
print("-*---"*25+"\n")
n=int(input("Enter the value of n: "))

game = Game(n)

while not game.is_over():
    if game.current_player() == 0:
        print("Your turn. \nThere are", game.n, "sticks on the board.")
        action = int(input("How many sticks do you want to pick up?  "))
        while action < 1 or action > 3 or action > game.n:
            action = int(input("Invalid input!!! \nHow many sticks do you want to pick up? "))
        game.update(action)
        game.switch_player()
    else:
        print("AI's turn. There are", game.n, "sticks on the board.")
        value, action = minimax(game, 1, -math.inf, math.inf)
        print("AI picks up", action, "sticks.")
        game.update(action)
        game.switch_player()


if game.winner == 0:
    print("AI wins!")
    
elif game.winner == 1:
    print("You win!")

