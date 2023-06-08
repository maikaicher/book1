using mylogger;

namespace mygraphs {
  abstract public class GrafikElm {
    protected int randfarbe;
    protected MyLogger logger = null!;

    public GrafikElm(int initRandfarbe) {
      randfarbe = initRandfarbe;
      Console.WriteLine("GrafikElm erzeugt.");
    }
    
    public void registerLogger(MyLogger logger) {
      this.logger = logger;
    }

    public int getRandfarbe() {
      return randfarbe;
    }
    public void setRandfarbe(int newRandfarbe) {
      randfarbe = newRandfarbe;
    }
    virtual public void printInfo() {
      Console.WriteLine("Randfarbe: " + randfarbe);
    }    
  }
}