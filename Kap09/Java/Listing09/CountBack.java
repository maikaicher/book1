public class CountBack {
    public static void main(String[] args) {
        methode(10);
    }
        
    public static void methode(int lauf) {
        for (int i = lauf; i >= 0; i--) {
            System.out.println(i);
        }
    }
}
