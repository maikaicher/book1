public class FractalWorker {
  private int fromY;
  private int toY;
  private String name;
  private FractalBuilder fb;    

  public FractalWorker(int fromY, int toY, FractalBuilder fb, String name) {
    this.fromY = fromY;
    this.toY = toY;
    this.fb = fb;
    this.name = name;
  }

  public void doWork() {
    Console.WriteLine("Start Thread " + name);
    fb.calcPixel(fromY, toY);
    fb.threadDone();
  }
}
