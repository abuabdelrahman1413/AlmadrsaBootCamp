#!/usr/bin/env python3
from calc.calculator import calculator
num1 = int(input("Enter first num: "))
num2 = int(input("Enter second num: "))
op = input("Enter op: ")

match op:
	case "+":
		print(calculator.add(num1, num2))
	case "-":
		print(calculator.sub(num1, num2))
	case "*":
		print(calculator.mult(num1, num2))
	case "/":
		print(calculator.div(num1, num2))
	case "power":
		print(calculator.power(num1, num2))
	case "sqr":
		print(calculator.sqr(num1))
	case "Random":
		print(calculator.Random(num1, num2))

	case _:
		print("Not valid operation")
