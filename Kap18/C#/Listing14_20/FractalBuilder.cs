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
    public void calcPixel() {
        ComplexNumber z = new ComplexNumber(0,0);
        for (int r = 0; r < dimY; r++) {
            for (int c = 0; c < dimX; c++) {
                z.reset();
                double re =       startRe - (halfDimRe - c) * pixelDist;
                double im = -1 * (startIm - (halfDimIm - r) * pixelDist);

                for (int i = 0; i < maxIteration; i++) {
                z.square();
                z.addC(re, im);
                if (z.getDistSquare() > thresSquare) {
                    setPixel(r, c, i * 0xffffff / 2500);
                    break;
                }
                }
            }
        }
    }

    public void startCalculation() {
        calcPixel();
    }

    private void setPixel(int r, int c, int color) {
        pixel[r, c] = color; 
    }

    public void writeDataToFile(String fileName) {
        byte[] data = BitmapGenerator.prepareBmp(pixel);
        File.WriteAllBytes(fileName, data);
    }



}