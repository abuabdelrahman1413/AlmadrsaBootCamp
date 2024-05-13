#!/usr/bin/env python3
import random

attempts_list = []

def show_score():
	if not attempts_list:
		print("There's no score currently")
	else:
		print(f"The current heigh scorre is {attempts_list} attempts")

attempts = 0
rand_num = random.randint(1, 10)

print("Hello player! Welcome to the guesssing game")
player_name = input("What's your name? ")

do_you_wnat_play = (
	input(f"Hi {player_name}, would you like to play [Enter Yes/No]? ")
).lower()

if do_you_wnat_play == "no":
	print("That's cool, see you later")
	exit()
else:
	show_score()

while do_you_wnat_play == "yes":
	try:
		guess = int(input("Pick a number in range [1/10]: "))
		if guess > 10 or guess < 1:
			raise ValueError ("Picka a number in the range.")
		attempts += 1
		
		if guess == rand_num:
			print("Nice you got it")
			do_you_wnat_play = (
				input(f"Would you like to play again [Enter Yes/No]? ")
			).lower()

			attempts_list.append(attempts)

			if do_you_wnat_play == "no":
				print("That's cool, have a good day!")
				show_score()
			else:
				attempts = 0
				rand_num = random.randint(1, 10)
				show_score()
				continue
		elif guess < rand_num:
			print("it's lower!")
		else:
			print("it's higher")				

	except ValueError as err:
		print(err)