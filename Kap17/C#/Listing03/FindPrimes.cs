public class FindPrimes {
    public static List<int> getPrimes(int maxVal) {
        long start = DateTimeOffset.Now.ToUnixTimeMilliseconds();
        List<int> primes = new List<int>();
                
        for (int i = 2; i <= maxVal; i++) {
            bool isPrime = true;
            for (int d = 2; d < i; d++) {
            if (i%d == 0) {
                isPrime = false;
            }
            } 
            if (isPrime) {
                primes.Add(i);
            }
        }

        Console.WriteLine(DateTimeOffset.Now.ToUnixTimeMilliseconds() - start);
        return primes;
    }
}