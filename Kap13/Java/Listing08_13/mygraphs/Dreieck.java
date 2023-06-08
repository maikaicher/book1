package Kap13.Java.Listing08_13.mygraphs;

public final class Dreieck extends ZweiDElm {
    private double seiteA = 1;
    private double seiteB = 1;
    private double seiteC = 1;

    public Dreieck(double a, double b, double c) {
      if (checkValues(a, b, c)) {
        seiteA = a;
        seiteB = b;
        seiteC = c;
        berechneFlaeche();
      }
    }

    private boolean checkValues(double a, double b, double c) {
      if (a + b <= c || b + c <= a || c + a <= b) {
        return false;
      }
      return true;
    }

    private void berechneUmfang() {
        umfang = seiteA + seiteB + seiteC;
    }

    private void berechneFlaeche() {
        berechneUmfang();
        double s = umfang/2;
        flaeche = Math.sqrt(s * (s - seiteA) * (s - seiteB) * (s - seiteC));
    }
}
