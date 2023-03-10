import javax.swing.*;

public class ParseTest {
  public static void main(String[] args) {
    String sEingabe = JOptionPane.showInputDialog("Eingabe Alter:");
    int iAlter = Integer.parseInt(sEingabe);
    if (iAlter < 18) {
      System.out.println("Minderjährig");
    } else {
      System.out.println("Volljährig");
    }
  }
}