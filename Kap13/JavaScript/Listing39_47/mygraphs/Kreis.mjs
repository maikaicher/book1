import ZweiDElm from "./ZweiDElm.mjs";

export default class Kreis extends ZweiDElm {
    #radius;
     
    constructor(initRandfarbe, initFuellfarbe, radius) {
      super(initRandfarbe, initFuellfarbe);
      this.#radius = radius;
      this.berechneUmfang();
      this.berechneFlaeche();
      console.log("Kreis erzeugt.");
    }
    
    berechneUmfang() {
        this.umfang = 2*this.#radius * Math.PI;
    }

    berechneFlaeche() {
        this.flaeche = this.#radius * this.#radius * Math.PI;
    }

    setRadius(radius) {
        this.#radius = radius;
    }
    
    getRadius() {
      return this.#radius;
    }

    printInfo() {
      super.printInfo();
      console.log("Radius: " + this.#radius);
    }
}