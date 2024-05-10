#!/usr/bin/env python3
import random

player = input("Choose 'p' for paper 'r' for rock 's' for scissor: ")
pc = random.choice(["p", "r", "s"])

print("player choose: " + player)
print("pc choose: " + pc)

if player == pc:
    print("Tie")
elif (player == "r" and pc  == "s") or (player == "s" and pc == "p") or (player == "p" and pc == "r"):
    print("Player won!")
else:
    print("You lose")
