class ToDoList:
    def __init__(self):
        self.tasks = []

    def add_task(self, task):
        self.tasks.append(task)
        print("Task added")

    def view_tasks(self):
        if not self.tasks:
            print("There are no tasks to view")
        else:
            for task in self.tasks:
                print(task)

    def remove_task(self, task):
        if not self.tasks:
            print("There are no tasks to remove")
        else:
            if task not in self.tasks:
                print("Task not found")
            else:
                self.tasks.remove(task)
                print("Task removed")
