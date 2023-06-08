package Kap13.Java.Listing39_48;

import Kap13.Java.Listing39_48.mygraphs.*;
import Kap13.Java.Listing39_48.mylogger.*;

public class Grafikprogramm {
  public int instanceVar = 0;

  public static void main(String[] args) {
    Rechteck myR = new Rechteck(0x000000, 0xff0000, 3.0, 2.0);
    myR.registerLogger(new MyLogger() {
      public void doLog(String data) {
        System.out.println("neuer Logeintrag: " + data);
      }
    });

    // Alternative Listing 48:
    /* 
    myR.registerLogger((data) -> {
      System.out.println("Neuer Logeintrag:" + data);
    });
    */
    
    Dreieck myD = new Dreieck(0x000000, 0xff0000, 3.0, 2.0, 2.0);
    MyLogger logger1 = new MyJsonLogger();
    myD.registerLogger(logger1);

    Kreis myK = new Kreis(0x000000, 0xff0000, 3.0);
    MyLogger logger2 = new MyPlainLogger();
    myK.registerLogger(logger2);

    System.out.println(myR.getUmfang());
    System.out.println(myD.getUmfang());
    System.out.println(myK.getUmfang());
  }
}
