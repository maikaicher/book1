def sq(x):
    return x * x

def squareListFunc(listIn):
    return list(map(sq, listIn))

print(squareListFunc([2, 4, 8]))
