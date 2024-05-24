#!/usr/bin/env python3

from tkinter import *
import random

# Tic Tac Toe Game for Two Players

def play(row, col):
    """
    Handles a player's move.
    """
    global player
    if block_btns[row][col]["text"] == "" and not check_winner():
        block_btns[row][col]["text"] = player
        block_btns[row][col].config(fg="blue" if player == "X" else "red")
        if check_winner():
            label.config(text=f"Player {player} wins!", fg="green")
            color_winner()
        elif is_tie():
            label.config(text="It's a Tie!", fg="orange")
        else:
            player = "O" if player == "X" else "X"
            label.config(text=f"Player {player}'s turn", fg="black")

def check_winner():
    """
    Checks if there is a winner.
    """
    for row in range(3):
        if block_btns[row][0]["text"] == block_btns[row][1]["text"] == block_btns[row][2]["text"] != "":
            return True
    for col in range(3):
        if block_btns[0][col]["text"] == block_btns[1][col]["text"] == block_btns[2][col]["text"] != "":
            return True
    if block_btns[0][0]["text"] == block_btns[1][1]["text"] == block_btns[2][2]["text"] != "":
        return True
    if block_btns[0][2]["text"] == block_btns[1][1]["text"] == block_btns[2][0]["text"] != "":
        return True
    return False

def is_tie():
    """
    Checks if the game is a tie.
    """
    for row in range(3):
        for col in range(3):
            if block_btns[row][col]["text"] == "":
                return False
    return True

def color_winner():
    """
    Colors the winning line.
    """
    for row in range(3):
        if block_btns[row][0]["text"] == block_btns[row][1]["text"] == block_btns[row][2]["text"] != "":
            for col in range(3):
                block_btns[row][col].config(bg="lightgreen")
    for col in range(3):
        if block_btns[0][col]["text"] == block_btns[1][col]["text"] == block_btns[2][col]["text"] != "":
            for row in range(3):
                block_btns[row][col].config(bg="lightgreen")
    if block_btns[0][0]["text"] == block_btns[1][1]["text"] == block_btns[2][2]["text"] != "":
        for i in range(3):
            block_btns[i][i].config(bg="lightgreen")
    if block_btns[0][2]["text"] == block_btns[1][1]["text"] == block_btns[2][0]["text"] != "":
        for i in range(3):
            block_btns[i][2-i].config(bg="lightgreen")

def restart():
    """
    Restarts the game.
    """
    global player
    player = random.choice(players)
    label.config(text=f"Player {player}'s turn", fg="black")
    for row in range(3):
        for col in range(3):
            block_btns[row][col].config(text="", bg="white", fg="black")

# Initialize the main window
window = Tk()
window.title("Tic Tac Toe")
window.minsize(300, 300)
window.config(bg="white")

# Initialize players and randomly select the starting player
players = ["X", "O"]
player = random.choice(players)

# Create the game label
label = Label(window, text=f"Player {player}'s turn", font=('Helvetica', 20), bg="white")
label.pack(pady=20)

# Create the restart button
restart_btn = Button(window, text="Restart", command=restart, font=('Helvetica', 14), bg="lightgrey")
restart_btn.pack(pady=10)

# Create the frame for the buttons
block_btns_frame = Frame(window, bg="white")
block_btns_frame.pack()

# Create the buttons for the Tic Tac Toe grid
block_btns = [[None for _ in range(3)] for _ in range(3)]
for row in range(3):
    for col in range(3):
        block_btns[row][col] = Button(block_btns_frame, text="", width=10, height=4,
                                      font=('Helvetica', 24),
                                      command=lambda row=row, col=col: play(row, col))
        block_btns[row][col].grid(row=row, column=col, padx=5, pady=5)

# Start the main event loop
window.mainloop()
