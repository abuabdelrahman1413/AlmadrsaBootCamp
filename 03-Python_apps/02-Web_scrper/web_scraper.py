#!/usr/bin/python3

import requests
from bs4 import BeautifulSoup

response = requests.get("https://books.toscrape.com")
soup = BeautifulSoup(response.content, "html.parser")

for book in soup.find_all('article'):
    print("The book title is: " + book.h3.a["title"] + " and it has " + book.p["class"][1] + " stars")
