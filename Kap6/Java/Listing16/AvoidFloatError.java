public class AvoidFloatError {
    public static void main(String[] args) {
        double d = Math.round(0.4 * 0.1 * 100);
        d = d / 100;
        System.out.println(d);
    }
}