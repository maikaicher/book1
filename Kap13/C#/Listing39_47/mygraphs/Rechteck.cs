namespace mygraphs {
  public sealed class Rechteck : ZweiDElm, Jsonifyable {
     protected double laenge;
    protected double breite;
     
    public Rechteck(int initRandfarbe, int initFuellfarbe, double laenge, double breite) : base(initRandfarbe, initFuellfarbe) {
      this.laenge = laenge;
      this.breite = breite;
      berechneUmfang();
      berechneFlaeche();
      Console.WriteLine("Rechteck erzeugt.");
    }

    public String getJsonString() {
      String jsonRep = 
        "{\"Typ: \":\"Rechteck\"" +
        ",\n\"Randfarbe\":" + randfarbe +
        ",\n\"Fuellfarbe\":" + fuellfarbe +
        ",\n\"Umfang\":" + umfang +
        ",\n\"Flaeche\":" + flaeche +
        ",\n\"Laenge\":" + laenge +
        ",\n\"Breite\":" + breite + "}";
      return jsonRep;
    }

    protected override void berechneUmfang() {
      umfang = 2*laenge + 2*breite;
    }

    protected override void berechneFlaeche() {
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
    
    public override void printInfo() {
      base.printInfo();
      Console.WriteLine("Laenge: " + laenge);
      Console.WriteLine("Breite: " + breite);
    }
  }	
}