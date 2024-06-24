import requests

from_currency = input("Enter currencey you want to convert from: ")
to_currency = input("Enter currencey you want to convert to: ")

while 1:
    try:
        amount = float(input("Enter amount of money: "))
       
    except:
        print("Amount must be numerical")
        continue
    if amount == 0:
        print("The amount must be > 0")
        continue
    else:
        break

import requests

url = f"https://api.apilayer.com/fixer/convert?to={to_currency}&from={from_currency}&amount={amount}"

payload = {}
headers= {
  "apikey": "XSKJZsvKFifTaB4bu0yBHeHHOu8C3JSi"
}

response = requests.request("GET", url, headers=headers, data = payload)

status_code = response.status_code
if status_code != 200:
    print("Sorry, try again later")
result = response.json()
print(f"{amount}{from_currency} = {result['result']}{to_currency}")