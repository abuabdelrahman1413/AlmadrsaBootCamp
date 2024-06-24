import tkinter as tk
from tkinter.filedialog import askopenfilename, asksaveasfilename
# Logic part
# """"""""""""""""""""""""""
# Open fun
def open_file():
    # Get file path
    file_path = askopenfilename(filetypes = [
        ("Text files", "*.txt"),("All files", "*.*")
    ])

    # Handle case if user cancel choose file
    if not file_path:
        return
    # Delete text box before open new file
    textBox.delete(1.0, tk.END)

    # Open new file inside text box
    with open(file_path, "r") as f:
        text = f.read()
        textBox.insert(tk.END, text)

        window.title(f"Text book - {file_path}")

def save_as():
    # Get file path
    file_path = asksaveasfilename(defaultextension= "text", filetypes = [
        ("Text files", "*.txt"),("All files", "*.*")
    ])

    # Handle case if user cancel choose file
    if not file_path:
        return

    # Open new file inside text box
    with open(file_path, "w") as f:
        text = textBox.get(1.0, tk.END)
        f.write(text)

        window.title(f"Text book - {file_path}")



# Gui part
# """"""""""""""""""""""""""
# Create a window
window = tk.Tk()
# Add title to window
window.title("Awsome text editor")
# Set minimum size of window
window.rowconfigure(0, minsize=600)
window.columnconfigure(1, minsize=800)
# Add textBox inside the window
textBox = tk.Text(window)
# Where textBox
textBox.grid(column=1, row=0, sticky="nsew")
# Create frame to put buttons inside it
frame_btn = tk.Frame(window, relief=tk.RAISED, bd= "4px")
# Where frame
frame_btn.grid(column=0, row=0, sticky="nw")
# Create 2 buttons save & open
btn_open = tk.Button(frame_btn, text="open", command=open_file)
btn_save = tk.Button(frame_btn, text="save", command=save_as)
# Where buttons
btn_open.grid(column=0, row=0, padx=5, pady=5, sticky="ew")
btn_save.grid(column=0, row=1, padx=5, pady=5, sticky="ew")

window.mainloop()