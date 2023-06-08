package Kap13.Java.Listing38.mygraphs;

abstract public class ZweiDElm extends FlaechenElm {
  protected double umfang = 0;
   
  public ZweiDElm(int initRandfarbe, int initFuellfarbe) {
    super(initRandfarbe, initFuellfarbe);
    System.out.println("ZweiDElm erzeugt.");
  }
 
  abstract protected void berechneUmfang();

  public double getUmfang() {
    return umfang;
  }
  public void printInfo() {
    super.printInfo();
    System.out.println("Umfang: " + umfang);
  }
}	

  