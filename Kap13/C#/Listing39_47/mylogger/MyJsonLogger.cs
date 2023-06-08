namespace mylogger {
  public class MyJsonLogger : MyLogger {
    public void doLog(String data) {
        Console.WriteLine("{\"message\":\"" + data + "\"}");
    }
  }
}