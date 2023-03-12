using System;
class Program {
    static void Main(string[] args) {
        int[][] zahlArray = new int[3][];
        zahlArray[0] = new int [4];
        zahlArray[1] = new int [3];
        zahlArray[2] = new int [5];
        Console.WriteLine ("Gesamtlänge: " + zahlArray.Length);
        Console.WriteLine("Breite bei 0: " + zahlArray[0].Length);
        Console.WriteLine("Breite bei 1: " + zahlArray[1].Length);
        Console.WriteLine("Breite bei 2: " + zahlArray[2].Length);
    }
}