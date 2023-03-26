import java.util.Scanner;

public class UmfangQuadrat {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    double a;
    if ((a = scanner.nextDouble()) > 0) {
      double umfang = 4*a;
      System.out.println(umfang);
    } else {
      System.out.println("Fehler");
    }
    scanner.close();
  }
}



