using mylogger;
using mygraphs;
    
Dreieck myD = new Dreieck(0x000000, 0xff0000, 3.0, 2.0, 2.0);
MyLogger logger1 = new MyJsonLogger();
myD.registerLogger(logger1);

Kreis myK = new Kreis(0x000000, 0xff0000, 3.0);
MyLogger logger2 = new MyPlainLogger();
myK.registerLogger(logger2);

Console.WriteLine(myD.getUmfang());
Console.WriteLine(myK.getUmfang());