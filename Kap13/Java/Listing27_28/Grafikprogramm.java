package Kap13.Java.Listing27_28;

import java.util.ArrayList;
import Kap13.Java.Listing27_28.mygraphs.*;

public class Grafikprogramm {
    public static void main(String[] args) {
        ArrayList<GrafikElm> allElements = new ArrayList<>();
        allElements.add(new Rechteck(0x000000, 0xffffff, 10.0, 5.0));
        allElements.add(new Kreis(0xff0000, 0x0000ff, 3.0));
        printAllInfos(allElements);
      }
      

    private static void printAllInfos(ArrayList<GrafikElm> allElements) {
        for(GrafikElm myElement : allElements) {
          myElement.printInfo();
        }
      }
      
}
