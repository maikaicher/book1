package Kap13.Java.Listing29_30.mygraphs;

public class ZweiDElm extends FlaechenElm {
  protected double umfang = 0;
   
  public ZweiDElm(int initRandfarbe, int initFuellfarbe) {
    super(initRandfarbe, initFuellfarbe);
    System.out.println("ZweiDElm erzeugt.");
  }
  public double getUmfang() {
    return umfang;
  }
  public void printInfo() {
    super.printInfo();
    System.out.println("Umfang: " + umfang);
  }
}	

  