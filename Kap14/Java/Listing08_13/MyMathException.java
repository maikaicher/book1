package Kap14.Java.Listing08_13;

public class MyMathException extends MyException {
  private String solution;
  public MyMathException(String message, int severity, String solution) {
    super(message, severity);
    this.solution = solution;
  }
  public String getSolution() {
    return solution;
  }
  public void doLog(int requiredLogLevel) {
    if (requiredLogLevel <= severity) {
      super.doLog(requiredLogLevel);
      System. err.println("Solution: " + solution);
    }
  }   
}
