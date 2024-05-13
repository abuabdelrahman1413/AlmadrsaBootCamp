#!/usr/bin/env python4
todo = []

while (True):
	user_input = input("Enter your action (add, view, remove, exit): ")

	if user_input == "add":
		task = input("Enter your task: ")
		todo.append(task)
		print("task added")
	elif user_input == "view":
		if not todo:
			print("There are no tasks to view")
		else:
			for task in todo:
				print(task)
	elif user_input == "remove":
		if not todo:
			print("There are no tasks to removed")
		else:
			task = input("Enter your task: ")
			if not task in todo:
				print("task not found")
			else:
				todo.remove(task)
				print("task removed")
	elif user_input == "exit":
		break
	else:
		print("invalid input")