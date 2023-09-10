public class ComplexCalculation {
    public static void exampleMultiplication() {
        ComplexNumber c = new ComplexNumber(5, 3);
        ComplexNumber c2 = c.multiply(new ComplexNumber(-0.5, 1));
        Console.WriteLine("Ergebnis: " + c2.im + "j + " + c2.re);
    }

    public static void rotatePoint(double re, double im) {
        ComplexNumber c = new ComplexNumber(5, 3);
        for (int i = 0; i < 23; i++) {
            c = c.multiply(new ComplexNumber(re, im));
            Console.WriteLine(c.im + ";" + c.re);
        }
    }
}