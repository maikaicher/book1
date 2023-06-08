from MyGraphs import Dreieck, Kreis
from MyLogger import MyJsonLogger, MyPlainLogger


myD = Dreieck(0x000000, 0xff0000, 3.0, 2.0, 2.0)
logger1 = MyJsonLogger()
myD.registerLogger(logger1)

myK = Kreis(0x000000, 0xff0000, 3.0);
logger2 = MyPlainLogger()
myK.registerLogger(logger2)

print(myD.getUmfang())
print(myK.getUmfang())
