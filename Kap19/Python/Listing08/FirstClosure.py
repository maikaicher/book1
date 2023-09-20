def outerFunction(a):
    innerVar = 3
    def innerFunction(a):
        return a * innerVar
    return innerFunction(a)

print(outerFunction(4))
