import java.util.Scanner;

public class UmfangQuadrat {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    double a = scanner.nextDouble();
    scanner.close();
    boolean isPositive = a > 0;
    if (isPositive) {
      double umfang = 4*a;
      System.out.println(umfang);
    } else {
      System.out.println("Fehler");
    }
  }
}

