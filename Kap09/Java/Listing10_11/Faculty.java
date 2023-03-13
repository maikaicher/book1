public class Faculty {
    public static void main(String[] args) {
      System.out.println(facultyIterative(5));
      System.out.println(facultyRecursive(5));
    }   
    public static int facultyIterative(int wert) {
        int ergebnis = 1;
        for (int i = 2; i <= wert; i++) {
          ergebnis *= i;
        }
        return ergebnis;
      }
      public static int facultyRecursive(int wert) {
        if (wert == 1) {
          return 1;
        }
        return facultyRecursive(wert - 1) * wert;
      }
      
       
}
