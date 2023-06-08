import ZweiDElm from "./ZweiDElm.mjs";

export default class Rechteck extends ZweiDElm {
    #laenge;
    #breite;
     
    constructor(initRandfarbe, initFuellfarbe, laenge, breite) {
      super(initRandfarbe, initFuellfarbe);
      this.#laenge = laenge;
      this.#breite = breite;
      this.berechneUmfang();
      this.berechneFlaeche();
      console.log("Rechteck erzeugt.");
    }

    getJsonString() {
      const jsonRep = 
        "{\"Typ: \":\"Rechteck\"" +
        ",\n\"Randfarbe\":" + randfarbe +
        ",\n\"Fuellfarbe\":" + fuellfarbe +
        ",\n\"Umfang\":" + umfang +
        ",\n\"Flaeche\":" + flaeche +
        ",\n\"Laenge\":" + laenge +
        ",\n\"Breite\":" + breite + "}";
      return jsonRep;
    }

    berechneUmfang() {
        this.umfang = 2*this.#laenge + 2*this.#breite;
    }

    berechneFlaeche() {
        this.flaeche = this.#laenge * this.#breite;
    }

    getLaenge() {
        return this.#laenge;
    }
      
    setLaenge(laenge) {
        this.#laenge = laenge;
    }

    getBreite() {
        return this.#breite;
    }
      
    setBreite(breite) {
        this.#breite = breite;
    }
    
    printInfo() {
      super.printInfo();
      console.log("Laenge: " + this.#laenge);
      console.log("Breite: " + this.#breite);
    }
}
