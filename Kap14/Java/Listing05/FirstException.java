package Kap14.Java.Listing05;

import javax.swing.JOptionPane;

public class FirstException {
    public static int getProzentZahl(int teil, int ganz) throws Exception {
    if (ganz == 0) {
        throw new Exception("Fehlerhafte Daten!");
    }
    return (int)(100.0 * teil / ganz);
    }

    public static void handleUserData() throws Exception {
    int teil = Integer.parseInt(JOptionPane.showInputDialog("Eingabe Teil:"));
    int ganz = Integer.parseInt(JOptionPane.showInputDialog("Eingabe Ganzes:"));
    int proz = getProzentZahl(teil, ganz);
    System.out.println("Das Ergebnis lautet " + proz + " Prozent");
    }

    public static void main(String[] args) throws Exception {
        handleUserData();
    }
        
}
