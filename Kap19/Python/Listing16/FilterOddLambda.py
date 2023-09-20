def removeOdd(listIn):
    return list(filter(lambda x: x%2 == 0, listIn))

print(removeOdd([1, 2, 3, 4, 5, 6]))
