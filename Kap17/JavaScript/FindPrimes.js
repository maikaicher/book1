let primes = getPrimes(100000);

function getPrimes(maxVal) {
    let start = Date.now();
    let primes = [];
                
    for (let i = 2; i <= maxVal; i++) {
        let isPrime = true;
        for (let d = 2; d < i; d++) {
            if (i%d == 0) {
                isPrime = false;
            }
        } 
        if (isPrime) {
            primes.push(i);
        }
    }

    console.log(Date.now() - start);
    return primes;
}
