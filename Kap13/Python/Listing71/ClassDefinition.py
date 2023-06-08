import abc

class GrafikElm (metaclass=abc.ABCMeta):
    def __init__(self, randfarbe):
        self._randfarbe = randfarbe
        print("GrafikElm erzeugt")

    @abc.abstractmethod
    def printInfo(self):
        print("Randfarbe: " + str(self._randfarbe))

class FlaechenElm (GrafikElm):
    def __init__(self, randfarbe, fuellfarbe):
        super().__init__(randfarbe)
        self._fuellfarbe = fuellfarbe
        self._flaeche = 0;
        print("FlaechenElm erzeugt")

    def printInfo(self):
        super().printInfo()
        print("Fuellfarbe: " + str(self._fuellfarbe))
        print("Flaeche: " + str(self._flaeche))

myFObj = FlaechenElm(1, 2)
myFObj.printInfo()
