// See https://aka.ms/new-console-template for more information
Console.WriteLine(getGrey(0xE9967A));


    static int getGrey(int iRgb) {
    int b = iRgb & 0xFF;
    iRgb >>= 8;
    int g = iRgb & 0xFF;
    iRgb >>= 8;
    int r = iRgb & 0xFF;
    int avg = (r + g + b) / 3;
    Console.WriteLine("R: " + r + "  G: " + g + "  B: " + b + " => " + avg);
    int grey = avg;
    grey |= (avg << 8);
    grey |= (avg << 16);
    return grey;
    }
