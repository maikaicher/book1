package Kap18.Java.Listing27_29;

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
    private int[][] pixel;
    private int noOfThreads = 0;
    private int delta = 0xffffff / 2500;

    public static void main(String[] args) {
        int dimX = 2048;
        int dimY = 1024;
        double threshold = 10;
        double startRe = 0.36001014891; 
        double startIm = 0.350001;  
        double pixelDist = 0.001; 
        int maxIteration = 50; 
        long start = System.currentTimeMillis();
        for (int i = 0; i < 50; i++) {
            FractalBuilder fb = new FractalBuilder(threshold, maxIteration, pixelDist, startRe, startIm, dimX, dimY);
            fb.startCalculation(8);
            fb.writeDataToFile("C:\\temp\\myFractal_" + i + ".bmp");
            System.out.println("Done Writing File " + i);
            pixelDist /= 2;
            maxIteration += 50;
        }
        System.out.println("Time in ms: " + (System.currentTimeMillis() - start));

    }    
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
        this.pixel = new int[dimY][dimX];
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
                    setPixel(r, c, i * this.delta);
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
            rFrom = rTo;
            changeNoOfThreads(true);

            // The following code can often be seen as:  new Thread(myWorker).start();
            Thread threadInstance = new Thread(myWorker);
            threadInstance.start();
        }
        do {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();          
            }
        } while (noOfThreads > 0);
    }


    private synchronized void changeNoOfThreads(boolean increase) {
        if (increase) {
            noOfThreads++;
        } else {
            noOfThreads--;
        }
    }

    private synchronized void setPixel(int r, int c, int color) {
        pixel[r][c] = color;
    }
    public void threadDone() {
        changeNoOfThreads(false);
    }


    public void writeDataToFile(String fileName) {
        byte[] data = BitmapGenerator.prepareBmp(pixel);
        BitmapGenerator.writeAllBytes(fileName, data);
    }



}