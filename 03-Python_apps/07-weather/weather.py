import requests
import tkinter as tk
from tkinter import messagebox

# Logi part
# """"""""""""""""""""""""""""""""""""""""""""""""
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
#""""""""""""""""""""""""""""""""""""
window = tk.Tk()
window.title("Weather App")
window.geometry("400x300")
window.configure(bg="#D3D3D3")

# Location Input
location_input_label = tk.Label(window, text="Enter city name:")
location_input_label.grid(column=0, row=0, padx=10, pady=10, sticky="w")
city_entry = tk.Entry(window, width=30)
city_entry.grid(column=1, row=0, padx=10, pady=10)

# Search Button
search_button = tk.Button(window, text="Search", command=get_weather)
search_button.grid(column=1, row=1, padx=10, pady=10)

# Frame for output labels
frame_output = tk.Frame(window)
frame_output.grid(column=0, row=2, columnspan=2, padx=10, pady=10, sticky="w")

# Temperature Label
temp_label = tk.Label(frame_output, text="Temperature:")
temp_label.grid(column=0, row=0, pady=5, sticky="w")
temperature_label = tk.Label(frame_output, text="")
temperature_label.grid(column=1, row=0, pady=5, sticky="w")

# Humidity Label
humid_label = tk.Label(frame_output, text="Humidity:")
humid_label.grid(column=0, row=1, pady=5, sticky="w")
humidity_label = tk.Label(frame_output, text="")
humidity_label.grid(column=1, row=1, pady=5, sticky="w")

# Wind Speed Label
wind_label = tk.Label(frame_output, text="Wind Speed:")
wind_label.grid(column=0, row=2, pady=5, sticky="w")
wind_speed_label = tk.Label(frame_output, text="")
wind_speed_label.grid(column=1, row=2, pady=5, sticky="w")

# Pressure Label
press_label = tk.Label(frame_output, text="Pressure:")
press_label.grid(column=0, row=3, pady=5, sticky="w")
pressure_label = tk.Label(frame_output, text="")
pressure_label.grid(column=1, row=3, pady=5, sticky="w")

# Precipitation Label
precip_label = tk.Label(frame_output, text="Precipitation:")
precip_label.grid(column=0, row=4, pady=5, sticky="w")
precipitation_label = tk.Label(frame_output, text="")
precipitation_label.grid(column=1, row=4, pady=5, sticky="w")

window.mainloop()
