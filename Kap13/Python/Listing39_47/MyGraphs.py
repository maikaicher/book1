import abc
import math

class GrafikElm (metaclass=abc.ABCMeta):

    @abc.abstractmethod
    def __init__(self, randfarbe):
        self._randfarbe = randfarbe
        self._logger = None
        print("GrafikElm erzeugt")

    def registerLogger(self, logger):
        self._logger = logger

    def getRandfarbe(self):
        return self._randfarbe

    def setRandfarbe(self, randfarbe):
        self._randfarbe = randfarbe
    
    def printInfo(self):
        print("Randfarbe: " + self._randfarbe)


class FlaechenElm (GrafikElm, metaclass=abc.ABCMeta):

    @abc.abstractmethod
    def __init__(self, randfarbe, fuellfarbe):
        super().__init__(randfarbe)
        self._fuellfarbe = fuellfarbe
        self._flaeche = 0
        print("FlaechenElm erzeugt")

    @abc.abstractmethod
    def berechneFlaeche(self):
        return
        
    def getFuellfarbe(self):
        return self._fuellfarbe

    def setFuellfarbe(self, fuellfarbe):
        self._fuellfarbe = fuellfarbe
    
    def getFlaeche(self):
        return self._flaeche

    def printInfo(self):
        super().printInfo()
        print("Fuellfarbe: " + self._fuellfarbe)
        print("Flaeche: " + self._flaeche)


class ZweiDElm (FlaechenElm, metaclass=abc.ABCMeta):

    @abc.abstractmethod
    def __init__(self, randfarbe, fuellfarbe):
        FlaechenElm.__init__(self, randfarbe, fuellfarbe)
        self._umfang = 0
        print("ZweiDElm erzeugt")

    @abc.abstractmethod
    def berechneUmfang(self):
        return    
    
    def getUmfang(self):
        if  self._logger != None :
            self._logger.doLog("Umfang wurde abgefragt.");
        return self._umfang;        

    def printInfo(self):
        super().printInfo()
        print("Umfang: " + self._umfang)
        

class Jsonifyable (metaclass=abc.ABCMeta):

    @abc.abstractmethod
    def __init__(self, randfarbe, fuellfarbe):
        return
    
    @abc.abstractmethod
    def getJsonString(self):
        return
    

class Dreieck (ZweiDElm):

    def __init__(self, randfarbe, fuellfarbe, a, b, c):
        super().__init__(randfarbe, fuellfarbe)
        print("Start Konstruktor Dreieck")
        if self.checkValues(a, b, c):
            self.__seiteA = a
            self.__seiteB = b
            self.__seiteC = c
            self.berechneFlaeche()
        print("Ende Konstruktor Dreieck")

    def checkValues(self, a, b, c) :
        if a + b <= c or b + c <= a or c + a <= b :
            return False
        return True
    
    def berechneUmfang(self):
        self._umfang = self.__seiteA + self.__seiteB + self.__seiteC

    def berechneFlaeche(self):
        self.berechneUmfang()
        s = self._umfang / 2
        self._flaeche = math.sqrt(s * (s - self.__seiteA) * (s - self.__seiteB) * (s - self.__seiteC))
    
    def getSeiteA(self):
        return self.__seiteA
    
    def getSeiteB(self):
        return self.__seiteB
    
    def getSeiteC(self):
        return self.__seiteC
    
    def setSeiteA(self, a):
        if self.checkValues(a, self.__seiteB, self.__seiteC):
            self.__seiteA = a
    
    def setSeiteB(self, b):
        if self.checkValues(self.__seiteA, b, self.__seiteC):
            self.__seiteB = b
    
    def setSeiteC(self, c):
        if self.checkValues(self.__seiteA, self.__seiteB, c):
            self.__seiteC = c

    def printInfo(self):
        super().printInfo()
        print("Seite A: " + self.__seiteA)
        print("Seite B: " + self.__seiteB)
        print("Seite C: " + self.__seiteC)
        

class Kreis (ZweiDElm):

    def __init__(self, randfarbe, fuellfarbe, radius):
        super().__init__(randfarbe, fuellfarbe)
        print("Start Konstruktor Kreis")
        self.__radius = radius
        self.berechneUmfang()
        self.berechneFlaeche()
        print("Ende Konstruktor Kreis")
    
    def berechneUmfang(self):
        self._umfang = 2 * self.__radius * math.pi

    def berechneFlaeche(self):
        self._flaeche = self.__radius * self.__radius * math.pi
    
    def getRadius(self):
        return self.__radius
    
    def setRadius(self, radius):
        self.__radius = radius
    
    def printInfo(self):
        super().printInfo()
        print("Radius: " + self.__radius)


class Rechteck (ZweiDElm, Jsonifyable):

    def __init__(self, randfarbe, fuellfarbe, lanege, breite):
        ZweiDElm.__init__(randfarbe, fuellfarbe)
        self.__laenge = lanege
        self.__breite = breite
        self.berechneUmfang()
        self.berechneFlaeche()
        print("Rechteck erzeugt")
    
    def getJsonString(self):
        jsonRep = "{\"Typ: \":\"Rechteck\"" + ",\n\"Randfarbe\":" + self._randfarbe + ",\n\"Fuellfarbe\":" + self._fuellfarbe + ",\n\"Umfang\":" + self._umfang + ",\n\"Flaeche\":" + self._flaeche + ",\n\"Laenge\":" + self.__laenge + ",\n\"Breite\":" + self.__breite + "}";
        return jsonRep
    
    def berechneUmfang(self):
        self._umfang = 2 * self.__lanege + 2 * self.__breite

    def berechneFlaeche(self):
        self._flaeche = self.__lanege * self.__breite
    
    def getLaenge(self):
        return self.__laenge
    
    def getBreite(self):
        return self.__breite
    
    def setLaenge(self, laenge):
        self.__laenge = laenge
    
    def setBreite(self, breite):
        self.__breite = breite
    
    def printInfo(self):
        super().printInfo()
        print("Laenge: " + self.__laenge)
        print("Breite: " + self.__breite)
