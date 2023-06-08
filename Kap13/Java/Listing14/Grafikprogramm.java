package Kap13.Java.Listing14;

import Kap13.Java.Listing14.mygraphs.*;

public class Grafikprogramm {
    public static void main(String[] args) {
        Dreieck myTr = new Dreieck(3.0, 4.0, 5.0);
        System.out.println(myTr.fuellfarbe);
        myTr.seiteC = 3.5;
    }
}
