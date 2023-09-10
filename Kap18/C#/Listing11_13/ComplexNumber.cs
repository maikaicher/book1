public class ComplexNumber {
  public double re {get; set;}
  public double im {get; set;}
  public ComplexNumber(double re, double im) {
    this.re = re;
    this.im = im;
  }
  public ComplexNumber multiply(ComplexNumber c) {
    double r = c.re * re - c.im * im;
    double i = im * c.re + re * c.im;
    return new ComplexNumber(r, i);
  }
  public ComplexNumber add(ComplexNumber c) {
    double r = c.re + re;
    double i = c.im + im;
    return new ComplexNumber(r, i);
  }
  public double getDist() {
    return Math.Sqrt(re * re + im * im);
  }
}
