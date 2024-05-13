#!/usr/bin/env python3

"""Module contain class of cat"""

class cat():
    """Cat class"""

    def __init__(self, name, type_of_cat, color, age, can_run, can_walk):
        self.name = name
        self.type_of_cat = type_of_cat
        self.color = color
        self.age = age
        self.can_run = can_run
        self.can_walk = can_walk

    def run(self):
        """Function to print the cat's speed in run"""
        string = f"I am {self.name}, "
        string += f"I am {self.age} months old, "
        string += f"My color is {self.color}, "
        string += f"I am s {self.type_of_cat} and I run {self.can_run} steps/s"

        print(string)


    def walk(self):
        """Function to print the cat's speed in walk"""
        string = f"I am {self.name}, "
        string += f"I am {self.age} months old, "
        string += f"My color is {self.color}, "
        string += f"I am s {self.type_of_cat} and I wall {self.can_walk} steps/s"

        print(string)
