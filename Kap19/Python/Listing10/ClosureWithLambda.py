def outerFunction(a, b):
    return (lambda x: x * b)(a)

print(outerFunction(4, 3))
