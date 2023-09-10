using System;
using System.Threading;
using System.Runtime.CompilerServices;

public class MyMainHandler {
  private int noOfThreads;
  private int kumErg = 0;
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

// Für Listing 10 nicht mehr notwendig [MethodImpl(MethodImplOptions.Synchronized)]
  public void doConsumingStuff(String name) {
    Console.WriteLine("doConsumingStuff - " + name + " called me");
    Thread.Sleep(100); // Simulation für Berechnung ohne kumErg Relevanz
    Monitor.Enter(this);  // Listing 10
    int localKumErg = kumErg;
    Thread.Sleep(100); // Simulation für Berechnung mit kumErg Relevanz
    localKumErg++; // Beispielhaft für eine Ergebnisübertragung
    kumErg = localKumErg;
    Monitor.Exit(this);  // Listing 10
    Console.WriteLine("doConsumingStuff - Done with call of " + name);

  }
}
