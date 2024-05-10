#!/usr/bin/python3

import requests
from bs4 import BeautifulSoup

def fetch_books_info(url):
    """
    Fetches book information from a given URL.

    Args:
        url (str): The URL of the webpage containing book information.

    Returns:
        list: A list containing dictionaries with book titles and star ratings.
    """

    # Send an HTTP GET request to fetch webpage content
    response = requests.get(url)

    # Check if request was successful
    if response.status_code != 200:
        print("Failed to fetch webpage:", response.status_code)
        return []

    # Parse the HTML content of the webpage
    soup = BeautifulSoup(response.content, "html.parser")

    books_info = []

    # Extract book titles and star ratings
    for book in soup.find_all('article'):
        book_title = book.h3.a["title"]
        star_rating = book.p["class"][1]
        books_info.append({"title": book_title, "stars": star_rating})

    return books_info

def main():
    """
    Main function to fetch and display book information.
    """

    # URL of the webpage containing book information
    url = "https://books.toscrape.com"

    # Fetch book information
    books_info = fetch_books_info(url)

    # Display book information
    for book_info in books_info:
        print(f"The book title is: {book_info['title']} and it has {book_info['stars']} stars")

if __name__ == "__main__":
    main()
