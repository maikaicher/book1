def sq(x):
    return x * x

def squareList(listIn):
    listOut = []
    i = 0
    for x in listIn:
        listOut.insert(i, sq(x))
        i += 1
    return listOut
print(squareList([2, 4, 8]))
