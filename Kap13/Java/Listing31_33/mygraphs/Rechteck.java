package Kap13.Java.Listing31_33.mygraphs;

public class Rechteck extends ZweiDElm {
    protected double laenge;
    protected double breite;
     
    public Rechteck(int initRandfarbe, int initFuellfarbe, 
                    double laenge, double breite) {
      super(initRandfarbe, initFuellfarbe);
      this.laenge = laenge;
      this.breite = breite;
      berechneUmfang();
      berechneFlaeche();
      System.out.println("Rechteck erzeugt.");
    }

    protected void berechneUmfang() {
      umfang = 2*laenge + 2*breite;
    }

    protected void berechneFlaeche() {
      flaeche = laenge * breite;
    }

    public double getLaenge() {
        return laenge;
      }
      
      public void setLaenge(int laenge) {
          this.laenge = laenge;
      }

      public double getBreite() {
        return breite;
      }
      
      public void setBreite(int breite) {
          this.breite = breite;
      }
    
    public void printInfo() {
      super.printInfo();
      System.out.println("Laenge: " + laenge);
      System.out.println("Breite: " + breite);
    }
  }
  