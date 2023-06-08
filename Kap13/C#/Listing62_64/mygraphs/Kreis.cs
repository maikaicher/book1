namespace mygraphs {
  public class Kreis : ZweiDElm {
     protected double radius;
     
    public Kreis(int initRandfarbe, int initFuellfarbe, double radius) : base(initRandfarbe, initFuellfarbe) {
      this.radius = radius;
      berechneUmfang();
      berechneFlaeche();
      Console.WriteLine("Kreis erzeugt.");
    }
    
    protected override void berechneUmfang() {
      umfang = 2*radius * Math.PI;
    }

    protected override void berechneFlaeche() {
      umfang = radius * radius * Math.PI;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    public double getRadius() {
      return radius;
    }

      public override void printInfo() {
      base.printInfo();
      Console.WriteLine("Radius: " + radius);
    }
  }
}