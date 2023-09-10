package Kap18.Java.Listing27_29;

public class ComplexNumber {
  protected double re;
  protected double im;
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
    return Math.sqrt(re * re + im * im);
  }
  public void square() {
    double r = re * re - im * im;
    double i = 2 * re * im;
    re = r;
    im = i;
  }
  public double getDistSquare() {
    return re * re + im * im;
  }
  public void addC(double re, double im) {
    this.re += re;
    this.im += im;
  }
  public void reset() {
    re = 0; 
    im = 0;
  }
}

