   
import time
import math

def getPrimes(maxVal):
    start = time.time()
    primes = [];
                    
    for i in range(2, maxVal, 1):
        isPrime = True;
        for d in range(2, i, 1):
            if i%d == 0:
                isPrime = False
            if isPrime:
                primes.append(i)

    print(math.floor((time.time() - start)*1000))
    return primes

primes = getPrimes(100000)
