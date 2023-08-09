package Kap14.Java.Listing08_13;

public class MyExceptionWrapper extends MyException {
  private Exception errorCause;

  public MyExceptionWrapper(String message, int severity, 
      Exception errorCause) {
    super(message, severity);
    this.errorCause = errorCause;
  }
  public Exception getErrorCause() {
    return errorCause;
  }
  public void doLog(int requiredLogLevel) {
    if (requiredLogLevel <= severity) {
      super.doLog(requiredLogLevel);
      System.err.println("Fehlergrund: " + errorCause.getMessage());
    }
  }   
}
