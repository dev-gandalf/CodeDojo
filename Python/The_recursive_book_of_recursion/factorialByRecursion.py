def factorial(number):
    #Base case
    if number == 1:
        return 1
    #Recursive case
    else:
        return number * factorial(number - 1)

print(factorial(5))
