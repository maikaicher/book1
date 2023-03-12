
class AddValues {
    static void Main(string[] args) {
    int i = add(3, 20);
    Console.WriteLine("Ergebnis = " + i);
    i = add(3, 20, 50);
    Console.WriteLine("Ergebnis = " + i);
    }

    static int add(int a, int b) {
    return a + b;
    }

    static int add(int a, int b, int c) {
    return a + b + c;
    }

}
