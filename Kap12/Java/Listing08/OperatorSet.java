public class OperatorSet {
    public static void main(String[] args) {
        int i = 1;
        int j = (i = 3) + 2;
        System.out.println(i + " " + j);
    }
}