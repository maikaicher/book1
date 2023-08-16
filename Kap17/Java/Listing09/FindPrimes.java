package Kap17.Java.Listing09;

import java.util.ArrayList;

public class FindPrimes {
    public static void main(String[] args) {
         ArrayList<Integer> primes = getPrimes(10000000);
    }

    public static ArrayList<Integer> getPrimes(int maxVal) {
        long start = System.currentTimeMillis();
        ArrayList<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[maxVal];
        for (int i = 0; i < isPrime.length; i++) {
          isPrime[i] = true;
        }
        for (int d = 2; d <= Math.sqrt(maxVal); d++) {
          if (isPrime[d]) {
            for (int i = d*d; i < isPrime.length; i += d) {
              isPrime[i] = false;
            }
          } 
        }
        for (int i = 0; i < isPrime.length; i++) {
          if (isPrime[i]) {
            primes.add(i);
          }
        }
        System.out.println((System.currentTimeMillis() - start));
        return primes;
      }      
}
