using System;
using System.Threading;

public class MyMainHandler {
  public void startLogic() {
    MyThreadClass myThread = new MyThreadClass(this, "My first Thread");
    Thread threadInstance = new Thread(myThread.doYourWork);
    threadInstance.Start();
    Console.WriteLine("MainHandler: Logic started");
  }

  public void threadFinishInfo(String threadMessage) {
    Console.WriteLine("Thread said to MainHandler: " + threadMessage);
  }
}
