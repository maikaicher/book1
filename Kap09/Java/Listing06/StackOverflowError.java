public class StackOverflowError {
    public static void main(String[] args) {
        methode();
      }
          
      public static int methode() {
        int j = 1;
        System.out.println("in Methode");
        j += methode();
        System.out.println(j);
        return j;
      }       
}
