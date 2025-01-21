#Not same code as in book but wrote it this way for simplicity

def fibonacci(nthNumber):
    a,b = 1,1
    for i in range(1, nthNumber + 1):
        print(a)
        a,b = b, a+b

fibonacci(6)
