#!/usr/bin/env python3

"""
cats_script.py - A script to demonstrate the usage of the Cat class.

This script creates instances of the Cat class with different attributes and
calls methods like walk() and run() on them to demonstrate their behavior.
"""

from class_cat import cat

siami = cat("Hanafi", "siami", "Mishmishi", 6, 20, 3)
siami.walk()
siami.run()


shirazi = cat("simsima", "shirazi", "White", 3, 50, 10)
shirazi.walk()
shirazi.run()


habashi = cat("Anter", "habashi", "Mishmishi", 9, 100, 1)
habashi.walk()
habashi.run()
