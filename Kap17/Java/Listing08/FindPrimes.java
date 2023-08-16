package Kap17.Java.Listing08;

import java.util.ArrayList;

public class FindPrimes {
    public static void main(String[] args) {
         ArrayList<Integer> primes = getPrimes(10000000);
    }

    public static ArrayList<Integer> getPrimes(int maxVal) {
        long start = System.currentTimeMillis();
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= maxVal; i++) {
            boolean isPrime = true;
            double maxDivisor = Math.sqrt(i);
            for (int d : primes) {
                if (d > maxDivisor) {
                    break;
                }
                if (i%d == 0) {
                    isPrime = false;
                    break;
                }
            } 
            if (isPrime) {
                primes.add(i);
            }
        }
        System.out.println(System.currentTimeMillis() - start);
        return primes;
    }
}
