package Kap17.Java.Listing05_06;

import java.util.ArrayList;

public class FindPrimes {
    public static void main(String[] args) {
         ArrayList<Integer> primes = getPrimes(100000);
    }

    public static ArrayList<Integer> getPrimes(int maxVal) {
        long start = System.currentTimeMillis();
        ArrayList<Integer> primes = new ArrayList<>();
                
        for (int i = 2; i <= maxVal; i++) {
            boolean isPrime = true;
            for (int d = 2; d <= i/2; d++) {  //Listing06: for (int d = 2, g = i/2; d <= g; d++) 
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
