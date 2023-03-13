public class RecursionTest {
    public static void main(String[] args) {
        methode(10);
    }
        
    public static void methode(int lauf) {
      System.out.println(lauf);
      if (lauf == 0) {
        return;
      }
      methode(lauf - 1);
    }
}
