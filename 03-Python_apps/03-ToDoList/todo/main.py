from todo import ToDoList
from add_task import AddTask
from view_tasks import ViewTasks
from remove_task import RemoveTask

def main():
    todo_list = ToDoList()
    
    while True:
        user_input = input("Enter your action (add, view, remove, exit): ").strip().lower()

        if user_input == "add":
            AddTask.main(todo_list)
        elif user_input == "view":
            ViewTasks.main(todo_list)
        elif user_input == "remove":
            RemoveTask.main(todo_list)
        elif user_input == "exit":
            break
        else:
            print("Invalid input")

if __name__ == "__main__":
    main()
