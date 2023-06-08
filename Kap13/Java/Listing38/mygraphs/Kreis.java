package Kap13.Java.Listing38.mygraphs;

public class Kreis extends ZweiDElm {
    protected double radius;
     
    public Kreis(int initRandfarbe, int initFuellfarbe, double radius) {
      super(initRandfarbe, initFuellfarbe);
      this.radius = radius;
      berechneUmfang();
      berechneFlaeche();
      System.out.println("Kreis erzeugt.");
    }

    protected void berechneUmfang() {
      umfang = 2*radius * Math.PI;
    }

    protected void berechneFlaeche() {
      flaeche = radius * radius * Math.PI;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    public double getRadius() {
      return radius;
    }

      public void printInfo() {
      super.printInfo();
      System.out.println("Radius: " + radius);
    }
  }	
  