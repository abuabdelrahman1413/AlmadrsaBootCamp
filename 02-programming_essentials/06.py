#!/usr/bin/env python3
"""
Module to recommend you plant to care
"""

def plant_recomended(care):
    """
    Function to recommend you plant to care
    """
    if care == "low":
        print("cactus")
    elif care == "medium":
        print("Ivy")
    elif care == "high":
        print("Orchid")

plant_recomended("low")
plant_recomended("medium")
plant_recomended("high")
