package Kap17.Java.Listing01_02;

public class StringPerformance {
    public static void main(String[] args) {
        checkString();
        checkStringBuffer();
    }

    public static void checkString() {
        String myOut = "";
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
          myOut += "X";
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    public static void checkStringBuffer() {
        String myOut = "";
        long start = System.currentTimeMillis();
        StringBuffer myB = new StringBuffer();
        for (int i = 0; i < 100000; i++) {
          myB.append("X");
        }
        myOut = myB.toString();
        System.out.println(System.currentTimeMillis() - start);        
    }
}
