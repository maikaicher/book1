package Kap14.Java.Listing06;

import javax.swing.JOptionPane;

public class FirstTryCatch {
    public static int getProzentZahl(int teil, int ganz) throws Exception {
    if (ganz == 0) {
        throw new Exception("Fehlerhafte Daten!");
    }
    return (int)(100.0 * teil / ganz);
    }

    public static void handleUserData() {
        boolean error;
        int teil, ganz, proz = 0;
        do {
          error = false;
          teil = Integer.parseInt(JOptionPane.showInputDialog("Eingabe Teil:"));
          ganz = Integer.parseInt(JOptionPane.showInputDialog("Eingabe Ganzes:"));
          try {
            proz = getProzentZahl(teil, ganz);
          } catch (Exception e) {
            System.out.println(e.getMessage());
            error = true;
          }
        } while (error);
        System.out.println("Das Ergebnis lautet " + proz + " Prozent");
      }
      

    public static void main(String[] args) throws Exception {
        handleUserData();
    }    
}
