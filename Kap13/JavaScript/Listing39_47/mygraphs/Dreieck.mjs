import ZweiDElm from "./ZweiDElm.mjs";

export default class Dreieck extends ZweiDElm {
    #seiteA = 1;
    #seiteB = 1;
    #seiteC = 1;

    constructor(initRandfarbe, initFuellfarbe, a, b, c) {
      super(initRandfarbe, initFuellfarbe);
      console.log("Start Konstruktor Dreieck");
      if (this.checkValues(a, b, c)) {
        this.#seiteA = a;
        this.#seiteB = b;
        this.#seiteC = c;
        this.berechneFlaeche();
      }
      console.log("Ende Konstruktor Dreieck");    
    }
    
    checkValues(a, b, c) {
      if (a + b <= c || b + c <= a || c + a <= b) {
        return false;
      }
      return true;
    }

    berechneUmfang() {
        this.umfang = this.#seiteA + this.#seiteB + this.#seiteC;
    }

    berechneFlaeche() {
        this.berechneUmfang();
        const s = this.umfang/2;
        this.flaeche = Math.sqrt(s * (s - this.#seiteA) * (s - this.#seiteB) * (s - this.#seiteC));
    }

    getSeiteA() {
      return this.#seiteA;
    }
    
    setSeiteA(a) {
      if (checkValues(a, this.#seiteB, this.#seiteC)) {
        this.#seiteA = a;
        this.berechneFlaeche();
      }
    }
    getSeiteB() {
      return this.#seiteB;
    }
    
    setSeiteB(b) {
      if (checkValues(this.#seiteA, b, this.#seiteC)) {
        this.#seiteB = b;
        this.berechneFlaeche();
      }
    }
    getSeiteC() {
      return this.#seiteA;
    }
    
    setSeiteC(c) {
      if (checkValues(this.#seiteA, this.#seiteB, c)) {
        this.#seiteC = c;
        this.berechneFlaeche();
      }
    }
    
    printInfo() {
      super.printInfo();
      console.log("Seite A: " + this.#seiteA);
      console.log("Seite B: " + this.#seiteB);
      console.log("Seite C: " + this.#seiteC);
   }
  
}