package Kap13.Java.Listing38.mygraphs;

abstract public class FlaechenElm extends GrafikElm {
  protected int fuellfarbe;
  protected double flaeche = 0;
   
  public FlaechenElm(int initRandfarbe, int initFuellfarbe) {
    super(initRandfarbe);
    fuellfarbe = initFuellfarbe;
    System.out.println("FlaechenElm erzeugt.");
  }
 
  abstract protected void berechneFlaeche();

  public int getFuellfarbe() {
    return fuellfarbe;
  }
  public void setFuellfarbe(int newFuellfarbe) {
    fuellfarbe = newFuellfarbe;
  }
  public double getFlaeche() {
    return flaeche;
  }
  public void printInfo() {
    super.printInfo();
    System.out.println("Fuellfarbe: " + fuellfarbe);
    System.out.println("Flaeche: " + flaeche);
  }
}

  
