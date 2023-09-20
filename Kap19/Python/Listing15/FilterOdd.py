def checkEven(x):
    if x%2 == 0:
        return x

def removeOdd(listIn):
    return list(filter(checkEven, listIn))
print(removeOdd([1, 2, 3, 4, 5, 6]))
