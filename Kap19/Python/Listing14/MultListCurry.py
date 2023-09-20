def mult(x):
    return lambda a: x * a

def multListFunc(listIn, b):
  return list(map(mult(b), listIn))

print(multListFunc([2, 4, 8], 2))
