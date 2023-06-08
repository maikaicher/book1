package Kap13.Java.Listing38;

import Kap13.Java.Listing38.mygraphs.*;

public class Grafikprogramm {
  public int instanceVar = 0;

  public static void main(String[] args) {
    Grafikprogramm myObj2 = new Grafikprogramm();
    myObj2.doSomething();
    myObj2.doSomething();
  }

  public void doSomething() {
    final int localOuterVar = 1;
    Jsonifyable myAnonObj = new Jsonifyable() {
      private int localInner = 0;
      public String getJsonString() {
        System.out.println("kann nicht geändert werden: " + localOuterVar);
        instanceVar++;
        return "{\"Typ:\":\"AnonymousObject\",\"count:\":" + instanceVar + "}";
      }
     };
     System.out.println(myAnonObj.getJsonString());
  }     
}
