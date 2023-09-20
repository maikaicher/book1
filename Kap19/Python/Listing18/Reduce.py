from functools import reduce

def fact(number):
    return reduce(lambda x, y: x * y, range(1, number + 1)) 

print(fact(5))
