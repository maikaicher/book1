def multWith(x, a):
    return x * a

def multListFunc(listIn, b):
  return list(map(lambda x: multWith(x, b), listIn))

print(multListFunc([2, 4, 8], 2))
