
class OverloadExample {
    static void Main(string[] args) {
        gebeUserAus("Hans", 20);
        gebeUserAus(20, "Hans");
    }

    static void gebeUserAus(String name, int alter) {
    Console.WriteLine("Der User heißt " + name + " und ist " + alter  + " Jahre alt");
    }

    static void gebeUserAus(int alter, String name) {
        Console.WriteLine("Der User hört auf " + name + " und ist " + alter  + " Jahre alt");
    }
}
