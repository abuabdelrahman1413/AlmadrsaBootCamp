class RemoveTask:
    @staticmethod
    def main(todo_list):
        task = input("Enter the task to remove: ").strip()
        todo_list.remove_task(task)
