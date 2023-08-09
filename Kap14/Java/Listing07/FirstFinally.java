package Kap14.Java.Listing07;

import javax.swing.JOptionPane;

public class FirstFinally {
    public static int getProzentZahl(int teil, int ganz) throws Exception {
    if (ganz == 0) {
        throw new Exception("Fehlerhafte Daten!");
    }
    return (int)(100.0 * teil / ganz);
    }

    public static void handleUserData() {
        int teil, ganz, proz = 0;
        teil = Integer.parseInt(JOptionPane.showInputDialog("Eingabe Teil:"));
        ganz = Integer.parseInt(JOptionPane.showInputDialog("Eingabe Ganzes:"));
        try {
          proz = getProzentZahl(teil, ganz);
        } catch (Exception e) {
          System.out.println(e.getMessage());
          return;
        } finally {
           System.out.println("Hier könnten Ressourcen freigegeben werden.");
        }
        System.out.println("Das Ergebnis lautet " + proz + " Prozent");
      }
      
      

    public static void main(String[] args) throws Exception {
        handleUserData();
    }      
}
