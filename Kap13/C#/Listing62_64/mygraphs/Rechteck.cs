namespace mygraphs {
  public class Rechteck : ZweiDElm, Jsonifyable {
     public double laenge {get; set;}
    
    // Code für Listing 62
    //public double breite {get; protected set;}
     


    public Rechteck(int initRandfarbe, int initFuellfarbe, double laenge, double breite) : base(initRandfarbe, initFuellfarbe) {
      this.laenge = laenge;
      this.breite = breite;
      berechneUmfang();
      berechneFlaeche();
      Console.WriteLine("Rechteck erzeugt.");
    }

    private double breite;
      public double Breite {
        get {
          return breite;
        }
        set {
          if (value > 0) {
            breite = value;
          } else {
            Console.WriteLine("zu klein");
          }
        }
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
      umfang = laenge * breite;
    }
    
    public override void printInfo() {
      base.printInfo();
      Console.WriteLine("Laenge: " + laenge);
      Console.WriteLine("Breite: " + breite);
    }
  }	
}