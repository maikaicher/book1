package Kap14.Java.Listing08_13;

import javax.swing.JOptionPane;

public class ExceptionExample {
    public static void main(String[] args) throws Exception {
        try {
          handleUserData();
        } catch (MyException me) {
          me.doLog(1);
        } catch (Exception ex) {
          System.err.println("Allgemeiner Fehler.");
        }
      }
      
    public static int getProzentZahl(int teil, int ganz) throws MyMathException {
    if (ganz == 0) {
        throw new MyMathException("Fehler!", 2, "Nicht durch 0 teilen!");
    }
    return (int)(100.0 * teil / ganz);
    }

    public static void handleUserData() throws MyException {
    int teil = 0, ganz = 0, proz = 0;
    String sTeil = "", sGanz = "";
    try {
        sGanz = JOptionPane.showInputDialog("Eingabe Ganzes:");
        if (sGanz.length() > 5) {
        throw new MyException("String zu lang:" + sGanz, 1);
        }
        ganz = Integer.parseInt(sGanz);
    } catch (NumberFormatException nfe) {
        throw new MyExceptionWrapper("Fehler: " + sGanz, 2, nfe);
    }
    try {
        sTeil = JOptionPane.showInputDialog("Eingabe Teil:");
        if (sTeil.length() > 5) {
        throw new MyException("String zu lang:" + sTeil, 1);
        }
        teil = Integer.parseInt(sTeil);
    } catch (NumberFormatException nfe) {
        throw new MyExceptionWrapper("Fehler: " + sTeil, 2, nfe);
    }
    proz = getProzentZahl(teil, ganz);
    System.out.println("Das Ergebnis lautet " + proz + " Prozent");
    }
}

