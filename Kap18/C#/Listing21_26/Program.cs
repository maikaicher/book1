int dimX = 2048;
int dimY = 1024;
double threshold = 10;
double startRe = 0.36001014891; 
double startIm = 0.350001;  
double pixelDist = 0.001; 
int maxIteration = 50; 
long start = DateTimeOffset.Now.ToUnixTimeMilliseconds();
for (int i = 0; i < 5; i++) {
  FractalBuilder fb = new FractalBuilder(threshold, maxIteration, pixelDist, startRe, startIm, dimX, dimY);
  fb.startCalculation(8);
  fb.writeDataToFile("C:\\temp\\myFractal_" + i + ".bmp");
  Console.WriteLine("Done Writing File " + i);
  pixelDist /= 2;
  maxIteration += 50;
}
Console.WriteLine("Time in ms: " + (DateTimeOffset.Now.ToUnixTimeMilliseconds() - start));
