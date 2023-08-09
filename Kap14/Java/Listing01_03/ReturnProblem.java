package Kap14.Java.Listing01_03;

public class ReturnProblem {
    public static void main(String[] args) {
        // clean call getRechteckFlaeche1
        System.out.println(getRechteckFlaeche1(10, 20));

        // wrong call getRechteckFlaeche1
        System.out.println(getRechteckFlaeche1(-10, 20));

        // clean call getProzentZahl
        System.out.println(getProzentZahl(20, 400));

        // wrong call getProzentZahl
        System.out.println(getProzentZahl(20, 0));        
    }

    public static int getRechteckFlaeche1(int a, int b) {
        return a * b;
    }

    public static int getRechteckFlaeche2(int a, int b) {
        if (a <= 0 || b <= 0) {
          return -1;
        }
        return a * b;
    }

    public static int getProzentZahl(int teil, int ganz) {
        return (int)(100.0 * teil / ganz);
    }     
}