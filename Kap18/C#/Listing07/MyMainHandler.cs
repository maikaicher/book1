using System;
using System.Threading;

public class MyMainHandler {
  private int noOfThreads;
  private int kumErg = 0;
  public bool doConsumingStuffIsBlocked = false;
  public void startLogic() {
    noOfThreads = 0;
    MyThreadClass myThread1 = new MyThreadClass(this, "Thread 1");
    MyThreadClass myThread2 = new MyThreadClass(this, "Thread 2");
    Thread threadInstance1 = new Thread(myThread1.doThreadedWork);
    noOfThreads++;
    threadInstance1.Start();
    Thread.Sleep(50); // change to 300
    Thread threadInstance2 = new Thread(myThread2.doThreadedWork);
    noOfThreads++;
    threadInstance2.Start();
    while (noOfThreads > 0) {
      Thread.Sleep(10);
    }
    Console.WriteLine("startLogic - kumErg: " + kumErg);
  }

  public void threadFinishInfo(String threadMessage) {
    Console.WriteLine(threadMessage);
    noOfThreads--;
  }

  public void doConsumingStuff(String name) {
    doConsumingStuffIsBlocked = true;
    Console.WriteLine("doConsumingStuff - " + name + " called me");
    int localKumErg = kumErg;
    Thread.Sleep(200);
    localKumErg++; // Beispielhaft für eine Ergebnisübertragung
    kumErg = localKumErg;
    Console.WriteLine("doConsumingStuff - Done with call of " + name);
    doConsumingStuffIsBlocked = false;
  }
}
