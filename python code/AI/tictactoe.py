def print_board(board):
    print()
    for i in range(0, 9):
        if i > 0 and (i) % 3 == 0:
            print()
            print()
        if board[i] == 0:
            print("__ ", end="  ")
        if board[i] == -1:
            print("X", end="   ")
        if board[i] == 1:
            print("O", end="   ")
    print()


def user_move(board):
    print("enter Xs  position from [1-9]")
    p = int(input())
    if (board[p-1] != 0):
        print("invalid move")
        exit(0)
    else:
        board[p-1] = -1
        print_board(board)
        # array_label = tkinter.Label(window, text="\n".join(str(row) for row in board))


def ai_move(board):
    pos = -1
    value = -2
    for i in range(0, 9):
        if (board[i] == 0):
            board[i] = 1
            score = -minmax(board, -1)
            board[i] = 0
            if score > value:
                value = score
                pos = i
    board[pos] = 1
    print("board after ai's move")
    print_board(board)


def minmax(board, player):
    x = check_finished(board)
    if (x != 0):
        return (x*player)
    pos = -1
    value = -2
    for i in range(0, 9):
        if (board[i] == 0):
            board[i] = player
            score = -minmax(board, (player*-1))
            if (score > value):
                value = score
                pos = i
            board[i] = 0

    if (pos == -1):
        return 0
    return value


def check_finished(board):
    wb = [[0, 1, 2], [3, 4, 5], [6, 7, 8], [0, 3, 6],
          [1, 4, 7], [2, 5, 8], [0, 4, 8], [2, 4, 6]]
    for i in range(0, 8):
        if (board[wb[i][0]] != 0 and board[wb[i][0]] == board[wb[i][1]] and board[wb[i][0]] == board[wb[i][2]]):
            return board[wb[i][2]]
    return 0


board = [0, 0, 0, 0, 0, 0, 0, 0, 0]
print("ai O vs you X")
player = input("Enter to play 1(st) or 2(nd) :")
player = int(player)
for i in range(0, 9):
    if (check_finished(board) != 0):
        break
    if ((i+player) % 2 == 0):
        ai_move(board)
    else:
        user_move(board)
x = check_finished(board)
if (x == 0):
    print("Draw!!!")
if (x == -1):
    print("X Wins!!! O Loose !!!")

if (x == 1):
    print("X Loose!!! O Wins !!!!")
