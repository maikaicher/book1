export default class GrafikElm {
    logger = null;

    constructor(initRandfarbe) {
        if (new.target === GrafikElm) {
            throw TypeError("Error!");
        }
        this.randfarbe = initRandfarbe;
        console.log("GrafikElm erzeugt.");
    }
    
    registerLogger(logger) {
      this.logger = logger;
    }

    getRandfarbe() {
      return this.randfarbe;
    }
    setRandfarbe(newRandfarbe) {
      this.randfarbe = newRandfarbe;
    }
    printInfo() {
      console.log("Randfarbe: " + this.randfarbe);
    }
}
