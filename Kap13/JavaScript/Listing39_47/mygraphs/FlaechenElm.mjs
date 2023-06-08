import GrafikElm from "./GrafikElm.mjs";

export default class FlaechenElm extends GrafikElm {
    flaeche = 0;
     
    constructor(initRandfarbe, initFuellfarbe) {
        super(initRandfarbe);
        if (new.target === FlaechenElm) {
            throw TypeError("Error!");
        }
        this.fuellfarbe = initFuellfarbe;
        console.log("FlaechenElm erzeugt.");
    }
   
    berechneFlaeche() {
        throw TypeError("Error!");
    }
  
    getFuellfarbe() {
      return this.fuellfarbe;
    }

    setFuellfarbe(newFuellfarbe) {
      this.fuellfarbe = newFuellfarbe;
    }

    getFlaeche() {
      return this.flaeche;
    }

    printInfo() {
      super.printInfo();
      console.log("Fuellfarbe: " + this.fuellfarbe);
      console.log("Flaeche: " + this.flaeche);
    }
}