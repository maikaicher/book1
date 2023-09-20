def mult(x):
    return lambda a: x * a

print(mult(2)(4))

# with one additional step:
tmpFunc = mult(2)
print(tmpFunc(4))