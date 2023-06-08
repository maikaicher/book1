namespace mylogger {
  public class MyPlainLogger : MyLogger {
    public void doLog(String data) {
        Console.WriteLine(data);
    }
  }
}
