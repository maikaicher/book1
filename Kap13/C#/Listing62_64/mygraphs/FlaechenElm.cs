namespace mygraphs {
  abstract public class FlaechenElm : GrafikElm {
    protected int fuellfarbe;
    protected double flaeche = 0;
    
    public FlaechenElm(int initRandfarbe, int initFuellfarbe) : base(initRandfarbe) {
        fuellfarbe = initFuellfarbe;
        Console.WriteLine("FlaechenElm erzeugt.");
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
    public override void printInfo() {
        base.printInfo();
        Console.WriteLine("Fuellfarbe: " + fuellfarbe);
        Console.WriteLine("Flaeche: " + flaeche);
    }
  }
}