package Kap17.Java.Listing11;

public class QuickSort {
    public static void main(String[] args) {
        int[] ar = {6, 3, 5, 2, 1, 4};
        quickSort(ar, 0, ar.length - 1);
        
        // output:
        for (int val : ar) {
            System.out.println(val);
        }        
    }

    public static void quickSort(int[] ar, int left, int right) {
        if (left < right) {
          int posReferenz = teileMenge(ar, left, right);
          quickSort(ar, left, posReferenz - 1);
          quickSort(ar, posReferenz + 1, right);
        }
      }
      
      public static int teileMenge(int[] ar, int left, int right) {
        int iL = left;
        int iR = right - 1;
        int referenz = ar[right];
        while (iL < iR) {
          while (iL <= iR && ar[iL] < referenz) iL++;
          while (iR >= iL && ar[iR] >= referenz) iR--;
          if (iL < iR) {
            int tmp = ar[iL];
            ar[iL] = ar[iR];
            ar[iR] = tmp;
          }
        }
        if (ar[iL] > referenz) {
          int tmp = ar[iL];
          ar[iL] = ar[right];
          ar[right] = tmp;
        }
        return iL;
      }
      
    
}
