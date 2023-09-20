def multWith(x, a):
    return x * a

# this will not work:
def multListFunc(listIn, param):
    # this call is not possible:
  return list(map(multWith, listIn, param))

print(multListFunc([2, 4, 8], 2))