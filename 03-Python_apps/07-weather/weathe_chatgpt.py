import requests
import tkinter as tk
from tkinter import messagebox

def get_weather():
    city = city_entry.get()
    if city:
        api_key = "5fc684ee91d26e365075041a9f561ece"  # Replace with your OpenWeatherMap API key
        url = f"http://api.openweathermap.org/data/2.5/weather?q={city}&appid={api_key}&units=metric"
        response = requests.get(url)
        if response.status_code == 200:
            data = response.json()
            weather = data['weather'][0]['description']
            temperature = data['main']['temp']
            humidity = data['main']['humidity']
            wind_speed = data['wind']['speed']
            pressure = data['main']['pressure']

            if 'rain' in data:
                precipitation = data['rain'].get('1h', 0)
                precip_text = f"{precipitation} mm"
            else:
                precip_text = "0 mm"

            temperature_label.config(text=f"{temperature}°C")
            humidity_label.config(text=f"{humidity}%")
            wind_speed_label.config(text=f"{wind_speed} m/s")
            pressure_label.config(text=f"{pressure} hPa")
            precipitation_label.config(text=precip_text)

# GUI part
window = tk.Tk()
window.title("Weather App")
window.geometry("400x350")
window.configure(bg="#1E90FF")

# Heading
heading_label = tk.Label(window, text="Weather App", bg="#1E90FF", fg="white", font=("Arial", 16, "bold"))
heading_label.pack(pady=10)

# Location Input
location_frame = tk.Frame(window, bg="#1E90FF")
location_frame.pack(pady=5)
location_input_label = tk.Label(location_frame, text="Enter city name:", bg="#1E90FF", fg="white", font=("Arial", 12))
location_input_label.grid(column=0, row=0, padx=5, pady=5)
city_entry = tk.Entry(location_frame, width=30, font=("Arial", 12))
city_entry.grid(column=1, row=0, padx=5, pady=5)
city_entry.focus()

# Search Button
search_button = tk.Button(window, text="Search", command=get_weather, bg="#FFD700", fg="black", font=("Arial", 12))
search_button.pack(pady=5)

# Frame for output labels
frame_output = tk.Frame(window, bg="#1E90FF")
frame_output.pack(pady=10)

# Labels
labels = ["Temperature:", "Humidity:", "Wind Speed:", "Pressure:", "Precipitation:"]
for i, label_text in enumerate(labels):
    label = tk.Label(frame_output, text=label_text, bg="#1E90FF", fg="white", font=("Arial", 12))
    label.grid(column=0, row=i, pady=5, padx=10, sticky="w")
    value_label = tk.Label(frame_output, text="", bg="#1E90FF", fg="white", font=("Arial", 12))
    value_label.grid(column=1, row=i, pady=5, padx=10, sticky="w")

# Keep references to value labels
temperature_label, humidity_label, wind_speed_label, pressure_label, precipitation_label = frame_output.winfo_children()[1::2]

window.mainloop()
