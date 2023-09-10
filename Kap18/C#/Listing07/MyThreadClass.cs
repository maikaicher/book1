public class MyThreadClass {
  private MyMainHandler mainProg;
  private String name;
  public MyThreadClass(MyMainHandler mainProg, String name) {
    this.mainProg = mainProg;
    this.name = name;
  }

  public void doThreadedWork() {
    Console.WriteLine("doThreadedWork - Start of " + name);
    while(mainProg.doConsumingStuffIsBlocked) {
      Thread.Sleep(10);
    }
    mainProg.doConsumingStuff(name);
    mainProg.threadFinishInfo("doThreadedWork - I'm done: " + name);
  }
}
