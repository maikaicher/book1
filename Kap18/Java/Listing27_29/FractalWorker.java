package Kap18.Java.Listing27_29;

public class FractalWorker implements Runnable {
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

  public void run() {
    fb.calcPixel(fromY, toY);
    fb.threadDone();
  }
}