def outerFunction(a, b):
    def innerFunction(a):
        return a * b
    return innerFunction(a)

print(outerFunction(4, 3))
