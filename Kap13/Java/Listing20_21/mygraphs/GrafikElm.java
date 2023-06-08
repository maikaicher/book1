package Kap13.Java.Listing20_21.mygraphs;

public class GrafikElm {
    protected int randfarbe;
     
    public GrafikElm(int initRandfarbe) {
      randfarbe = initRandfarbe;
      System.out.println("GrafikElm erzeugt.");
    }
    public int getRandfarbe() {
      return randfarbe;
    }
    public void setRandfarbe(int newRandfarbe) {
      randfarbe = newRandfarbe;
    }
    public void printInfo() {
      System.out.println("Randfarbe: " + randfarbe);
    }
  }
  

