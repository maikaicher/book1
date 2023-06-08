package Kap13.Java.Listing34_37;

import Kap13.Java.Listing34_37.mygraphs.*;

public class Grafikprogramm {
    public static void main(String[] args) {
      Jsonifyable myObj = new Rechteck(0x000000, 0xffffff, 10.0, 5.0);
      System.out.println(myObj.getJsonString());


      // Listing 37:
      Jsonifyable myAnonObj = new Jsonifyable() {
        public String getJsonString() {
          return "{\"Typ:\":\"AnonymousObject\"}";
        }
      };
      System.out.println(myAnonObj.getJsonString());
      
    }      
}
