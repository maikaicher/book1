package Kap13.Java.Listing24_26.mygraphs;

public class Kreis extends ZweiDElm {
    protected double radius;
     
    public Kreis(int initRandfarbe, int initFuellfarbe, double radius) {
      super(initRandfarbe, initFuellfarbe);
      this.radius = radius;
      berechneUmfang();
      berechneFlaeche();
      System.out.println("Kreis erzeugt.");
    }

    private void berechneUmfang() {
      umfang = 2*radius * Math.PI;
    }

    private void berechneFlaeche() {
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
  