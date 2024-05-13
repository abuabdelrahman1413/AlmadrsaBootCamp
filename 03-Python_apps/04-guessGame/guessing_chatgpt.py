#!/usr/bin/env python3
import random

def show_score(attempts_list):
    """
    Display the current high score.

    Args:
        attempts_list (list): List containing the attempts made by the player.
    """
    if attempts_list:
        print(f"The current high score is {min(attempts_list)} attempts")
    else:
        print("There's no score currently")

def play_game():
    """
    Play the guessing game.

    Returns:
        int: Number of attempts made by the player to guess the correct number.
    """
    attempts = 0
    rand_num = random.randint(1, 10)

    while True:
        try:
            guess = int(input("Pick a number in the range [1/10]: "))
            if guess < 1 or guess > 10:
                raise ValueError("Please pick a number in the range.")
            
            attempts += 1
            
            if guess == rand_num:
                print("Nice, you got it!")
                return attempts
            elif guess < rand_num:
                print("It's higher!")
            else:
                print("It's lower!")

        except ValueError as err:
            print(err)

def main():
    """
    Main function to run the game.
    """
    attempts_list = []

    print("Hello player! Welcome to the guessing game")
    player_name = input("What's your name? ")

    while True:
        do_you_want_play = input(f"Hi {player_name}, would you like to play? (yes/no): ").lower()
        
        if do_you_want_play == "no":
            print("That's cool, see you later!")
            break
        elif do_you_want_play == "yes":
            attempts = play_game()
            attempts_list.append(attempts)

            show_score(attempts_list)

        else:
            print("Please enter either 'yes' or 'no'.")

if __name__ == "__main__":
    main()
