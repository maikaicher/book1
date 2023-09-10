using System;
using System.Threading;

public class MyMainHandler {
  private bool threadRunning;
  public void startLogic() {
    MyThreadClass myThread = new MyThreadClass(this, "My first Thread");
    Thread threadInstance = new Thread(myThread.doYourWork);
    threadRunning = true;
    threadInstance.Start();
    Console.WriteLine("MainHandler: Logic started");
    while (threadRunning) {
      Thread.Sleep(10);
    }
  }

  public void threadFinishInfo(String threadMessage) {
    Console.WriteLine("Thread said to MainHandler: " + threadMessage);
    threadRunning = false;
  }
}
