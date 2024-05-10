#!/usr/bin/env python3

"""
Module to read file contect 
and print it in another file
"""

filer = open("05-strings.txt", "r")
fileo = open("05-strings_output.txt", "w")


capital = ["I", "Almdrasa"]
for line in filer:
    if line != "I\n" and line != "Almdrasa\n":
        line = line.lower()
    line = line.rstrip()
    words = words + " "+line
print(words, file=fileo)
fileo.close()
