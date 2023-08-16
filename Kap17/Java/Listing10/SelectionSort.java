package Kap17.Java.Listing10;

public class SelectionSort {
    public static void main(String[] args) {
        int[] ar = {6, 3, 5, 2, 1, 4};

        for (int i = 0; i < ar.length - 1; i++) {
          for (int j = i + 1; j < ar.length; j++) {
            if (ar[i] > ar[j]) {
              int tmp = ar[i];
              ar[i] = ar[j];
              ar[j] = tmp;
            }
          }
        }

        // output:
        for (int val : ar) {
            System.out.println(val);
        }
    }
}
