public class MyThreadClass {
  private MyMainHandler mainProg;
  private String name;
  public MyThreadClass(MyMainHandler mainProg, String name) {
    this.mainProg = mainProg;
    this.name = name;
  }

  public void doThreadedWork() {
    Console.WriteLine("doThreadedWork - Start of " + name);
    mainProg.doConsumingStuff(name);
    mainProg.threadFinishInfo("doThreadedWork - I'm done: " + name);
  }
}
