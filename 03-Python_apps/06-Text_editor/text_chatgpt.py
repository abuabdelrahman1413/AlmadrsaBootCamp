import tkinter as tk
from tkinter.filedialog import askopenfilename, asksaveasfilename
from tkinter.messagebox import showinfo
from tkinter.font import Font

# Logic part
def open_file():
    file_path = askopenfilename(filetypes=[("Text files", "*.txt"), ("All files", "*.*")])
    if not file_path:
        return
    textBox.delete(1.0, tk.END)
    with open(file_path, "r") as f:
        text = f.read()
        textBox.insert(tk.END, text)
    window.title(f"Awesome Text Editor - {file_path}")

def save_as():
    file_path = asksaveasfilename(defaultextension="txt", filetypes=[("Text files", "*.txt"), ("All files", "*.*")])
    if not file_path:
        return
    with open(file_path, "w") as f:
        text = textBox.get(1.0, tk.END)
        f.write(text)
    window.title(f"Awesome Text Editor - {file_path}")

def new_file():
    textBox.delete(1.0, tk.END)
    window.title("Awesome Text Editor - New File")

def about():
    showinfo("About", "Awesome Text Editor\nVersion 1.0")

def update_status(event=None):
    row, col = textBox.index(tk.INSERT).split('.')
    status_var.set(f"Line: {row} | Column: {col}")

# GUI part
window = tk.Tk()
window.title("Awesome Text Editor")
window.geometry("1000x700")
window.configure(bg='#2E2E2E')

# Configure grid layout
window.rowconfigure(0, minsize=25, weight=0)
window.rowconfigure(1, minsize=600, weight=1)
window.columnconfigure(0, minsize=800, weight=1)

# Define font
custom_font = Font(family="Helvetica", size=12)

# Text box configuration
textBox = tk.Text(window, wrap="word", undo=True, bg="#1E1E1E", fg="#D4D4D4", insertbackground="white", selectbackground="#4E4E4E", font=custom_font)
textBox.grid(column=0, row=1, sticky="nsew")
textBox.bind('<KeyRelease>', update_status)

# Menu bar
menu_bar = tk.Menu(window)
file_menu = tk.Menu(menu_bar, tearoff=0)
file_menu.add_command(label="New", command=new_file)
file_menu.add_command(label="Open", command=open_file)
file_menu.add_command(label="Save As", command=save_as)
file_menu.add_separator()
file_menu.add_command(label="Exit", command=window.quit)
menu_bar.add_cascade(label="File", menu=file_menu)

help_menu = tk.Menu(menu_bar, tearoff=0)
help_menu.add_command(label="About", command=about)
menu_bar.add_cascade(label="Help", menu=help_menu)

window.config(menu=menu_bar)

# Toolbar
toolbar = tk.Frame(window, bg='#3E3E3E')
btn_new = tk.Button(toolbar, text="New", command=new_file, bg="#3E3E3E", fg="white", padx=5, pady=5)
btn_open = tk.Button(toolbar, text="Open", command=open_file, bg="#3E3E3E", fg="white", padx=5, pady=5)
btn_save = tk.Button(toolbar, text="Save As", command=save_as, bg="#3E3E3E", fg="white", padx=5, pady=5)

btn_new.pack(side="left", padx=5, pady=5)
btn_open.pack(side="left", padx=5, pady=5)
btn_save.pack(side="left", padx=5, pady=5)
toolbar.grid(column=0, row=0, sticky="ew")

# Status bar
status_var = tk.StringVar()
status_bar = tk.Label(window, textvariable=status_var, bd=1, relief=tk.SUNKEN, anchor='w', bg='#3E3E3E', fg='white')
status_bar.grid(column=0, row=2, sticky='we')
update_status()

window.mainloop()
