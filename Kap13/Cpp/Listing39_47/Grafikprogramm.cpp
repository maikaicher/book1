#include <iostream>
#include <string>
#include <numbers>
#include <math.h>
#include "Logger.h"

class GrafikElm {
  public:
    GrafikElm(int);
    void registerLogger(MyLogger*);
    int getRandfarbe();
    void setRandfarbe(int);
    void printInfo();
    ~GrafikElm();
  protected:
    int randfarbe;
    MyLogger *logger;
};

class FlaechenElm : public GrafikElm {
  public:
    FlaechenElm(int, int);
    int getFuellfarbe();
    void setFuellfarbe(int);
    double getFlaeche();
    void printInfo();
  protected:
    int fuellfarbe;
    double flaeche;
    virtual void berechneFleaeche();      
};

class ZweiDElm : public FlaechenElm {
  public:
    ZweiDElm(int, int);
    double getUmfang();
    void printInfo();
  protected:
    double umfang;
    virtual void berechneUmfang();
};

class Jsonifyable {
  public:
    virtual std::string getJsonString();
};

class Dreieck : public ZweiDElm {
  public:
    Dreieck(int, int, double, double, double);
    double getSeiteA();
    double getSeiteB();
    double getSeiteC();
    void setSeiteA(double);
    void setSeiteB(double);
    void setSeiteC(double);
    void printInfo();
  protected:
    void berechneUmfang();
    void berechneFlaeche();
  private:
    double seiteA;
    double seiteB;
    double seiteC;
    bool checkValues(double, double, double);
};

class Kreis : public ZweiDElm {
  public:
    Kreis(int, int, double);
    void setRadius(double);
    double getRadius();
    void printInfo();
  protected:
    void berechneUmfang();
    void berechneFleaeche();
  private:
    double radius;
};

class Rechteck : public ZweiDElm, public Jsonifyable {
  public:
    Rechteck(int, int, double, double);
    std::string getJsonString();
    double getLaenge();
    double getBreite();
    void setLanege(double);
    void setBreite(double);
    void printInfo();
  protected:
    void berechneUmfang();
    void berechneFlaeche();
  private: 
    double laenge;
    double breite;
};

GrafikElm::GrafikElm(int initRandfarbe) {
    randfarbe = initRandfarbe;
    std::cout << "\nGrafikElm erzeugt.";
}



void GrafikElm::registerLogger(MyLogger *logger) {
    this->logger = logger;
}

int GrafikElm::getRandfarbe() {
    return randfarbe;
}

void GrafikElm::setRandfarbe(int newRandfarbe) {
    randfarbe = newRandfarbe;
}

void GrafikElm::printInfo() {
    std::cout << "\nRandfarbe: " << randfarbe;
}
GrafikElm::~GrafikElm() {
  if (this->logger != NULL) {
    delete(logger);
  }
}

FlaechenElm::FlaechenElm(int initRandfarbe, int initFuellfarbe) : GrafikElm(initRandfarbe) {
  fuellfarbe = initFuellfarbe;
  std::cout << "\nFlaechenElm erzeugt.";
}

void FlaechenElm::berechneFleaeche(){}

int FlaechenElm::getFuellfarbe() {
  return fuellfarbe;
}

void FlaechenElm::setFuellfarbe(int newFuellfarbe) {
    fuellfarbe = newFuellfarbe;
}

double FlaechenElm::getFlaeche() {
    return flaeche;
}

void FlaechenElm::printInfo() {
    GrafikElm::printInfo();
    std::cout << "\nFuellfarbe: " << fuellfarbe;
    std::cout << "\nFlaeche: " << flaeche;
}


ZweiDElm::ZweiDElm(int initRandfarbe, int initFuellfarbe) : FlaechenElm(initRandfarbe, initFuellfarbe) {
    std::cout << "\nZweiDElm erzeugt.";
}

void ZweiDElm::berechneUmfang(){};

double ZweiDElm::getUmfang() {
    if (logger != 0) {
        logger->doLog("Umfang wurde abgefragt");
    }
    return umfang;
}

void ZweiDElm::printInfo() {
    FlaechenElm::printInfo();
    std::cout << "\nUmfang: " << umfang;
}


std::string Jsonifyable::getJsonString(){return "";};

Dreieck::Dreieck(int initRandfarbe, int initFuellfarbe, double a, double b, double c) : ZweiDElm(initRandfarbe, initFuellfarbe) {
    std::cout << "\nStart Konstruktor Dreieck";
    if (checkValues(a, b, c)) {
        seiteA = a;
        seiteB = b;
        seiteC = c;
        berechneFlaeche();
    }    
    std::cout << "\nEnde Konstruktor Dreieck";
}

bool Dreieck::checkValues(double a, double b, double c) {
    if (a + b <= c || b + c <= a || c + a <= b) {
        return false;
    }
    return true;
}

void Dreieck::berechneUmfang() {
    umfang = seiteA + seiteB + seiteC;
}

void Dreieck::berechneFlaeche() {
    berechneUmfang();
    double s = umfang / 2;
    flaeche = sqrt(s * (s - seiteA) * (s - seiteB) * (s - seiteC));
}

double Dreieck::getSeiteA() {
  return seiteA;
}

double Dreieck::getSeiteB() {
  return seiteB;
}

double Dreieck::getSeiteC() {
  return seiteC;
}

void Dreieck::setSeiteA(double a) {
  if (checkValues(a, seiteB, seiteC)) {
    seiteA = a;
    berechneFlaeche();
  }
}

void Dreieck::setSeiteB(double b) {
  if (checkValues(seiteA, b, seiteC)) {
    seiteB = b;
    berechneFlaeche();
  }
}

void Dreieck::setSeiteC(double c) {
  if (checkValues(seiteA, seiteB, c)) {
    seiteC = c;
    berechneFlaeche();
  }
}

void Dreieck::printInfo() {
  ZweiDElm::printInfo();
  std::cout << "\nSeite A: " << seiteA;
  std::cout << "\nSeite B: " << seiteB;
  std::cout << "\nSeite C: " << seiteC;
}



Kreis::Kreis(int initRandfarbe, int initFuellfarbe, double radius) : ZweiDElm(initRandfarbe, initFuellfarbe) {
  this->radius = radius;
  berechneUmfang();
  berechneFleaeche();
  std::cout << "\nKreis erzeugt.";
}

void Kreis::berechneUmfang() {
  umfang = 2*radius * atan(1)*4; // atan(1)*4 is PI
}

void Kreis::berechneFleaeche() {
  flaeche = radius*radius * atan(1)*4; // atan(1)*4 is PI
}

void Kreis::setRadius(double radius) {
  this->radius = radius;
}

double Kreis::getRadius() {
  return radius;
}

void Kreis::printInfo() {
  ZweiDElm::printInfo();
  std::cout << "\nRadius: " << radius;
}

std::string Rechteck::getJsonString() {
  std::string jsonRep = "{\"Typ: \":\"Rechteck\",\n\"Randfarbe\": %d,\n\"Fuellfarbe\":" + std::to_string(fuellfarbe) + ",\n\"Umfang\":" + std::to_string(umfang) + ",\n\"Flaeche\":" + std::to_string(flaeche) + ",\n\"Laenge\":" + std::to_string(laenge) + ",\n\"Breite\":" + std::to_string(breite) + "}";
  return jsonRep;
}

void Rechteck::berechneUmfang() {
  umfang = 2*laenge + 2*breite;
}

void Rechteck::berechneFlaeche() {
  flaeche = laenge * breite;
}

double Rechteck::getLaenge() {
  return laenge;
}

double Rechteck::getBreite() {
  return breite;
}

void Rechteck::setLanege(double laenge) {
  this->laenge = laenge;
}

void Rechteck::setBreite(double breite) {
  this->breite = breite;
}

void Rechteck::printInfo() {
  ZweiDElm::printInfo();
  std::cout << "\nLaenge: " << laenge;
  std::cout << "\nBreite: " << breite;
}


Rechteck::Rechteck(int initRandfarbe, int initFuellfarbe, double laenge, double breite) : ZweiDElm(initRandfarbe, initFuellfarbe) {
  this->laenge = laenge;
  this->breite = breite;
  berechneUmfang();
  berechneFlaeche();
  std::cout << "\nRechteck erzeugt.";
}



int main() {
    Dreieck myD = Dreieck(0x000000, 0xff0000, 3.0, 2.0, 2.0);
    MyLogger *logger1 = new MyJsonLogger();
    myD.registerLogger(logger1);

    Kreis myK = Kreis(0x000000, 0xff0000, 3.0);
    MyLogger *logger2 = new MyPlainLogger();
    myK.registerLogger(logger2);

    std::cout << "\n" << myD.getUmfang();
    std::cout << "\n" << myK.getUmfang();


  return 0;
}
