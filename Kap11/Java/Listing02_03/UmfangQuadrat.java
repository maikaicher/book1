import java.util.Scanner;

public class UmfangQuadrat {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      double a = scanner.nextDouble();
      scanner.close();
      
      //if (a > 0) 
      //{double umfang = 4*a;System.out.println(umfang);} else {System.out.println("Fehler");}

      if (a > 0) {
        double umfang = 4*a;
        System.out.println(umfang);
      } else {
        System.out.println("Fehler");
      }
    }
  }
  
