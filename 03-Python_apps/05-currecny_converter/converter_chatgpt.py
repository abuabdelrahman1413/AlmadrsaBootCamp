import requests


def get_currency_input(prompt):
    """
    Prompt the user to input currency information.

    Args:
        prompt (str): The prompt message for the user.

    Returns:
        str: The currency input provided by the user.
    """
    currency_input = input(prompt)

    return currency_input


def get_amount_input():
    """
    Prompt the user to input the amount of money.

    Returns:
        float: The amount of money input by the user.
    """
    while True:
        try:
            amount = float(input("Enter amount of money: "))
            if amount <= 0:
                print("The amount must be greater than 0")
            else:
                return amount
        except ValueError:
            print("Amount must be numerical")


def convert_currency(from_currency, to_currency, amount):
    """
    Convert currency using an API call.

    Args:
        from_currency (str): The currency to convert from.
        to_currency (str): The currency to convert to.
        amount (float): The amount of money to convert.

    Returns:
        dict: The result of the currency conversion API call (JSON response).
    """
    url = f"https://api.apilayer.com/fixer/convert?to={to_currency}&from={from_currency}&amount={amount}"
    headers = {"apikey": "XSKJZsvKFifTaB4bu0yBHeHHOu8C3JSi"}
    response = requests.get(url, headers=headers)
    if response.status_code != 200:
        print("Sorry, try again later")
        return None
    result = response.json()
    return result


def display_conversion_result(amount, from_currency, result, to_currency):
    """
    Display the result of the currency conversion.

    Args:
        amount (float): The amount of money input by the user.
        from_currency (str): The currency converted from.
        result (dict): The result of the currency conversion API call (JSON response).
        to_currency (str): The currency converted to.
    """
    converted_amount = result["result"]
    print(f"{amount} {from_currency} = {converted_amount} {to_currency}")


def display_currency_options(prompt):
    """
    Display a list of currency options with corresponding numbers.

    Args:
        prompt (str): The prompt message for the user.

    Returns:
        str: The currency chosen by the user.
    """
    currency_options = [
        "USD - United States Dollar",
        "EUR - Euro",
        "GBP - British Pound Sterling",
        "JPY - Japanese Yen",
        "AUD - Australian Dollar",
        "AED - United Arab Emirates Dirham",
        "SAR - Saudi Riyal",
        "QAR - Qatari Riyal",
        "KWD - Kuwaiti Dinar",
        "BHD - Bahraini Dinar",
        "OMR - Omani Rial",
        "LYD - Libyan Dinar",
        "JOD - Jordanian Dinar",
        "DZD - Algerian Dinar",
        "EGP - Egyptian Pound",
        "SDG - Sudanece Pound",
        # Add more currency options as needed
    ]
    print(prompt)
    for i, option in enumerate(currency_options, 1):
        print(f"{i}. {option}")

    while True:
        try:
            choice = int(input("Enter the number corresponding to the currency: "))
            if 1 <= choice <= len(currency_options):
                return currency_options[choice - 1].split()[0]  # Extract currency code
            else:
                print("Invalid choice. Please enter a number within the range.")
        except ValueError:
            print("Invalid choice. Please enter a number.")


def main():
    print("Currency Converter")
    from_currency = display_currency_options(
        "Select currency you want to convert from:"
    )
    print("=======================================")

    to_currency = display_currency_options("Select currency you want to convert to:")
    print("=======================================")

    amount = get_amount_input()
    result = convert_currency(from_currency, to_currency, amount)
    if result:
        display_conversion_result(amount, from_currency, result, to_currency)


if __name__ == "__main__":
    main()
