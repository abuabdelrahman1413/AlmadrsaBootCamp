#!/usr/bin/env python3
from tkinter import *
import random
"""
Tic Toe game for two players module
"""

# Logic part
def play(row, col):
    """
    Player function
    """
    global player
    if block_btns[row][col]["text"] == "" and check_winner() == False:
        if player == "X":
            block_btns[row][col]["text"] = "X"
            if check_winner() == False:
                player = "O"
                label.config(text=f"Player {player}'s turn")
            elif check_winner() == True:
                label.config(text=f"Player {player} wins")
            elif check_winner() == "tie":
                label.config(text="Tie")
        else:
            block_btns[row][col]["text"] = "O"
            if check_winner() == False:
                player = "X"
                label.config(text=f"Player {player}'s turn")
            elif check_winner() == True:
                label.config(text=f"Player {player} wins")
            elif check_winner() == "tie":
                label.config(text="Tie")





def check_winner():
    """
    Check winner function
    """
    # check horizintal
    for row in range(3):
        if block_btns[row][0]["text"] == block_btns[row][1]["text"] == block_btns[row][2]["text"] != "":
            return True
    # check vertical
    for col in range(3):
        if block_btns[0][col]["text"] == block_btns[1][col]["text"] == block_btns[2][col]["text"] != "":
            return True
    # check diagonal
    if block_btns[0][0]["text"] == block_btns[1][1]["text"] == block_btns[2][2]["text"] != "":
        return True
    if block_btns[0][2]["text"] == block_btns[1][1]["text"] == block_btns[2][0]["text"] != "":
        return True
    # check tie
    counter = 0 
    for row in range(3):
        for col in range(3):
            if block_btns[row][col]["text"] != "":
                counter += 1
    if counter == 9:
        return "tie"
    return False

def restart():
    for row in range(3):
        for col in range(3):
            block_btns[row][col]["text"] = ""
    label.config(text=f"Player {player}'s turn")





# UI part
window = Tk()

# window title
window.title("Tic Tac Toe game")

# window min size
window.minsize(width=300, height=300)

# window max size
window.maxsize(width=800, height=600)

# player choices
players = ["X", "O"]

# random choice
player = random.choice(players)

# block_btns
block_btns = [
    [0,0,0],
    [0,0,0],
    [0,0,0]
]

# playr name label
label = Label(text=f"Player {player}'s turn")

# label position
label.pack(side=TOP, pady=10)

# restart button
restart_btn = Button(text="Restart", command=lambda: restart())

# restart button position
restart_btn.pack(side=TOP, pady=10)

# x, o bottons frame
block_btns_frame = Frame(window)
# Frame position
block_btns_frame.pack()

# x, o buttons
for row in range(3):
    for col in range(3):
        block_btns[row][col] = Button(block_btns_frame, text="", command=lambda row=row, col=col: play(row, col))
        # x, o buttons position
        block_btns[row][col].grid(row=row, column=col, padx=10, pady=10)
window.mainloop()