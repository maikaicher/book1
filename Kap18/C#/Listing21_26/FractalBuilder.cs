using System.Runtime.CompilerServices;

public class FractalBuilder {
  private int dimX;
  private int dimY;
  private int halfDimRe;
  private int halfDimIm;
  private int maxIteration;
  private double startRe;
  private double startIm;
  private double thresSquare;
  private double pixelDist;
  private int[,] pixel;
  private int noOfThreads = 0;
  private int delta = 0xffffff / 2500;


    public FractalBuilder(double threshold, int maxIteration, double pixelDist, double startRe, double startIm, int dimX, int dimY) {
        this.thresSquare = threshold * threshold;
        this.maxIteration = maxIteration;
        this.dimX = dimX;
        this.dimY = dimY;
        this.startRe = startRe;
        this.startIm = startIm; 
        this.pixelDist = pixelDist;
        this.halfDimRe = dimX / 2;
        this.halfDimIm = dimY / 2;
        this.pixel = new int[dimY, dimX];
    }
    public void calcPixel(int fromY, int toY) {
        ComplexNumber z = new ComplexNumber(0,0);
        for (int r = fromY; r < toY; r++) {
            for (int c = 0; c < dimX; c++) {
                z.reset();
                double re =       startRe - (halfDimRe - c) * pixelDist;
                double im = -1 * (startIm - (halfDimIm - r) * pixelDist);

                for (int i = 0; i < maxIteration; i++) {
                z.square();
                z.addC(re, im);
                if (z.getDistSquare() > thresSquare) {
                    setPixel(r, c, i * delta);
                    break;
                }
                }
            }
        }
    }
    public void startCalculation(int cpuCount) {
        int noLinesPerThread = dimY / cpuCount;
        int rFrom = 0;
        int rTo = 0;
        int threadCount = 0;
        for (int i = 1; i <= cpuCount; i++) {
            rTo = (i == cpuCount) ? dimY : i * noLinesPerThread;
            FractalWorker myWorker = new FractalWorker(rFrom, rTo, this, "thread " + threadCount++);
            Thread threadInstance = new Thread(myWorker.doWork);
            rFrom = rTo;
            changeNoOfThreads(true);
            threadInstance.Start();
        }
        do {
            Thread.Sleep(10);
        } while (noOfThreads > 0);
    }


    [MethodImpl(MethodImplOptions.Synchronized)]
    private void changeNoOfThreads(bool increase) {
        if (increase) {
            noOfThreads++;
        } else {
            noOfThreads--;
        }
    }

    [MethodImpl(MethodImplOptions.Synchronized)]
    private void setPixel(int r, int c, int color) {
        pixel[r, c] = color;
    }
    public void threadDone() {
        changeNoOfThreads(false);
    }

    public void writeDataToFile(String fileName) {
        byte[] data = BitmapGenerator.prepareBmp(pixel);
        File.WriteAllBytes(fileName, data);
    }
}