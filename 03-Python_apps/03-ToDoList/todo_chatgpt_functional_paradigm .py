#!/usr/bin/env python3
def add_task(todo_list, task):
    """
    Adds a task to the todo list.

    Args:
    - todo_list (list): The list containing the tasks.
    - task (str): The task to be added.
    """
    todo_list.append(task)
    print("Task added")

def view_tasks(todo_list):
    """
    Displays all tasks in the todo list.

    Args:
    - todo_list (list): The list containing the tasks.
    """
    if not todo_list:
        print("There are no tasks to view")
    else:
        for task in todo_list:
            print(task)

def remove_task(todo_list, task):
    """
    Removes a task from the todo list.

    Args:
    - todo_list (list): The list containing the tasks.
    - task (str): The task to be removed.
    """
    if not todo_list:
        print("There are no tasks to remove")
    else:
        if task not in todo_list:
            print("Task not found")
        else:
            todo_list.remove(task)
            print("Task removed")

def main():
    todo = []
    
    while True:
        user_input = input("Enter your action (add, view, remove, exit): ").strip().lower()

        if user_input == "add":
            task = input("Enter your task: ").strip()
            add_task(todo, task)
        elif user_input == "view":
            view_tasks(todo)
        elif user_input == "remove":
            task = input("Enter the task to remove: ").strip()
            remove_task(todo, task)
        elif user_input == "exit":
            break
        else:
            print("Invalid input")

if __name__ == "__main__":
    main()
