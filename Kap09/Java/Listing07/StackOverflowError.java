public class StackOverflowError {
    public static void main(String[] args) {
        methode();
      }
          
      public static int methode() {
        methode();
        return 0;
      }
            
}
