class Program {
    static void Main(string[] args) {
        printTimeOfDay(17);
   }

    static void printTimeOfDay(int h) {
    switch(h) {
    case int n when n < 7:
        Console.WriteLine("nachts");
        break;
    case int n when n < 11:
        Console.WriteLine("morgens");
        break;
    case int n when n < 13:
        Console.WriteLine("vormittags");
        break;
    case int n when n < 15:
        Console.WriteLine("mittags");
        break;
    case int n when n < 18:
        Console.WriteLine("nachmittags");
        break;
    case int n when n < 22:
        Console.WriteLine("abends");
        break;
    default:
        Console.WriteLine("nachts");
        break;
    }             
    }
}
