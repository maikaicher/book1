package Kap17.Java.Listing12;

import java.util.Arrays;

public class ArraySortExample {
    public static void main(String[] args) {
        int[] ar = {6, 3, 5, 2, 1, 4};
        Arrays.sort(ar);
        
        // output:
        for (int val : ar) {
            System.out.println(val);
        }        
    }
}
