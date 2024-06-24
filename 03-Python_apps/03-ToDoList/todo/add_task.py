class AddTask:
    @staticmethod
    def main(todo_list):
        task = input("Enter your task: ").strip()
        todo_list.add_task(task)
