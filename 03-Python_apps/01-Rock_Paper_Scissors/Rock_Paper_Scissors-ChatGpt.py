#!/usr/bin/env python3
import random

def main():
    """
    A simple Rock-Paper-Scissors game.
    """

    player_wins = 0
    pc_wins = 0

    for _ in range(3):
        # Get player input
        player = input("Choose 'p' for paper, 'r' for rock, 's' for scissor: ").lower()

        # Generate computer's choice
        pc = random.choice(["p", "r", "s"])

        # Print choices
        print("Player chose: " + player)
        print("PC chose: " + pc)

        # Determine the winner of the round
        winner = determine_winner(player, pc)

        # Print result of the round
        print(winner)

        # Update scores
        if winner == "Player wins!":
            player_wins += 1
        elif winner == "Computer wins!":
            pc_wins += 1

    # Print overall winner
    if player_wins > pc_wins:
        print("Player wins {} out of 3 rounds. Player is the overall winner!".format(player_wins))
    elif pc_wins > player_wins:
        print("Computer wins {} out of 3 rounds. Computer is the overall winner!".format(pc_wins))
    else:
        print("It's a tie! Both player and computer won the same number of rounds.")

def determine_winner(player, pc):
    """
    Determines the winner of the Rock-Paper-Scissors game.

    Args:
        player (str): Player's choice ('p', 'r', or 's').
        pc (str): Computer's choice ('p', 'r', or 's').

    Returns:
        str: The result of the game.
    """

    if player == pc:
        return "It's a tie!"
    elif (player == "r" and pc == "s") or (player == "s" and pc == "p") or (player == "p" and pc == "r"):
        return "Player wins!"
    else:
        return "Computer wins!"

if __name__ == "__main__":
    main()
