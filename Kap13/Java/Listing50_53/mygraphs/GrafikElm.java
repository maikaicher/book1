package Kap13.Java.Listing50_53.mygraphs;

import Kap13.Java.Listing50_53.mylogger.*;

public abstract class GrafikElm {
    protected int randfarbe;
    protected MyLogger logger = null;

    public GrafikElm(int initRandfarbe) {
      randfarbe = initRandfarbe;
      System.out.println("GrafikElm erzeugt.");
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
    public void printInfo() {
      System.out.println("Randfarbe: " + randfarbe);
    }
  }	
  
