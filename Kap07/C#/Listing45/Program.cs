using System;
class Program {
    static void Main(string[] args) {
        String stringVar1 = "hallo welt";
        Console.WriteLine(stringVar1.Equals("Hallo Welt", 
        StringComparison.OrdinalIgnoreCase));
    }
}