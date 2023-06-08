package Kap13.Java.Listing34_37.mygraphs;

public final class Dreieck extends ZweiDElm {
    private double seiteA = 1;
    private double seiteB = 1;
    private double seiteC = 1;

    public Dreieck(int initRandfarbe, int initFuellfarbe, double a, double b, double c) {
      super(initRandfarbe, initFuellfarbe);
      System.out.println("Start Konstruktor Dreieck");
      if (checkValues(a, b, c)) {
        seiteA = a;
        seiteB = b;
        seiteC = c;
        berechneFlaeche();
      }
      System.out.println("Ende Konstruktor Dreieck");    
    }

    private boolean checkValues(double a, double b, double c) {
      if (a + b <= c || b + c <= a || c + a <= b) {
        return false;
      }
      return true;
    }

    protected void berechneUmfang() {
        umfang = seiteA + seiteB + seiteC;
    }

    protected void berechneFlaeche() {
        berechneUmfang();
        double s = umfang/2;
        flaeche = Math.sqrt(s * (s - seiteA) * (s - seiteB) * (s - seiteC));
    }

    public double getSeiteA() {
      return seiteA;
    }
    
    public void setSeiteA(double a) {
      if (checkValues(a, seiteB, seiteC)) {
        seiteA = a;
        berechneFlaeche();
      }
    }
    public double getSeiteB() {
      return seiteB;
    }
    
    public void setSeiteB(double b) {
      if (checkValues(seiteA, b, seiteC)) {
        seiteB = b;
        berechneFlaeche();
      }
    }
    public double getSeiteC() {
      return seiteC;
    }
    
    public void setSeiteC(double c) {
      if (checkValues(seiteA, seiteB, c)) {
        seiteC = c;
        berechneFlaeche();
      }
    }
    
    public void printInfo() {
      super.printInfo();
      System.out.println("Seite A: " + seiteA);
      System.out.println("Seite B: " + seiteB);
      System.out.println("Seite C: " + seiteC);
   }
  
}
