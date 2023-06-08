namespace mygraphs {
  abstract public class ZweiDElm : FlaechenElm {
    protected double umfang = 0;
    
    public ZweiDElm(int initRandfarbe, int initFuellfarbe) : base(initRandfarbe, initFuellfarbe) {
        Console.WriteLine("ZweiDElm erzeugt.");
    }
    
    abstract protected void berechneUmfang();

    public double getUmfang() {
        if (logger != null) {
        logger.doLog("Umfang wurde abgefragt.");
        }
        return umfang;
    }


    public override void printInfo() {
        base.printInfo();
        Console.WriteLine("Umfang: " + umfang);
    }
  }	
}