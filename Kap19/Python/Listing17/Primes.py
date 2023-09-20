import math

def primeFilter(x, d):
    if x==d or x%d != 0:
        return x

def sieb(l, p, m):
    if l[p] <= m:
        return sieb(list(filter(lambda x: primeFilter(x, l[p]), l)), p + 1, m)
    return l

maxVal = 2000
l = range(2, maxVal + 1)
y = sieb(l, 0, math.sqrt(maxVal))

print(y)
