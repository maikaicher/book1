namespace mygraphs {
  public sealed class Dreieck : ZweiDElm {
    private double seiteA = 1;
    private double seiteB = 1;
    private double seiteC = 1;

    public Dreieck(int initRandfarbe, int initFuellfarbe, double a, double b, double c) : base(initRandfarbe, initFuellfarbe) {
      Console.WriteLine("Start Konstruktor Dreieck");
      if (checkValues(a, b, c)) {
        seiteA = a;
        seiteB = b;
        seiteC = c;
        berechneFlaeche();
      }
      Console.WriteLine("Ende Konstruktor Dreieck");    
    }
    
    private bool checkValues(double a, double b, double c) {
      if (a + b <= c || b + c <= a || c + a <= b) {
        return false;
      }
      return true;
    }

    protected override void berechneUmfang() {
        umfang = seiteA + seiteB + seiteC;
    }

    protected override void berechneFlaeche() {
        berechneUmfang();
        double s = umfang/2;
        flaeche = Math.Sqrt(s * (s - seiteA) * (s - seiteB) * (s - seiteC));
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
    
    public override void printInfo() {
      base.printInfo();
      Console.WriteLine("Seite A: " + seiteA);
      Console.WriteLine("Seite B: " + seiteB);
      Console.WriteLine("Seite C: " + seiteC);
   }
  }	
}