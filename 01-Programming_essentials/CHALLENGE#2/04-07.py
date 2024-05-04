num1 = int(input("Insert first num? "))
num2 = int(input("Insert second num? "))
op = input("Insert the op?")

ops = ["+", "-", "*"]
if op not in ops:
    print("We don't support this operation")
elif op == ops[0]:
    print("The result is: " , num1 + num2)
elif op == ops[1]:
    print("The result is: " , num1 - num2)
elif op == ops[2]:
    print("The result is: " , num1 * num2)


print()
print("Finally,")
print("Thanks for using our software")
