public class OperatorAnd {
    public static void main(String[] args) {
        int i = 1;
        int j = 0;
        if (i == 0 && j++ == 0) {
          System.out.println("true, j ist jetzt " + j);
        } else {
          System.out.println("false, j ist jetzt " + j);
        }
    }
}