using System;
using System.Collections.Generic;
class DynAr {
  static void Main(string[] args) { 
    List<string> myList = new List<string>();
    myList.Add("a");
    myList.Add("b");
    myList.Add("c");
    myList.Add("e");
    myList.Add("X");
    myList.Add("F");

    Console.WriteLine("Wert auf Position 1: " + myList[1]);
    myList.Insert(3, "d");
    myList.RemoveAt(5);
    myList[5] = "f";
    for (int i = 0; i < myList.Count; i++) {
      Console.WriteLine("Wert pos: " + i + ": "  + myList[i]);
    }
  }
}
