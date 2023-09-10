using System;
using System.Threading;

public class MyThreadClass {
  private String someInfo;
  private MyMainHandler mainProg;

  public MyThreadClass(MyMainHandler mainProg, String someInfo) {
    this.someInfo = someInfo;
    this.mainProg = mainProg;
  }

  public void doYourWork() {
    for (int i = 0; i < 5; i++) {
      Thread.Sleep(2000);
      Console.WriteLine("Info: " + someInfo + " on loop #" + i);
    }
    mainProg.threadFinishInfo("I'm done: " + someInfo);
  }
}
