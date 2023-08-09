package Kap14.Java.Listing08_13;

public class MyException extends Exception {
  protected int severity = 0;
  public MyException(String message, int severity) {
    super(message);
    this.severity = severity;
  }

  public int getSeverity() {
    return severity;
  }
    
  public void doLog(int requiredLogLevel) {
    if (requiredLogLevel <= severity) {
      System.err.println("Error: " + this.getMessage() 
          + "\nSeverity:" + severity);
    }
  }
}
