import FlaechenElm from "./FlaechenElm.mjs";

export default class ZweiDElm extends FlaechenElm {
    umfang = 0;
     
    constructor(initRandfarbe, initFuellfarbe) {
        super(initRandfarbe, initFuellfarbe);
        if (new.target === ZweiDElm) {
            throw TypeError("Error!");
        }
        console.log("ZweiDElm erzeugt.");
    }

    berechneUmfang() {
        throw TypeError("Error!");
    }
  
    getUmfang() {
        if (this.logger != null) {
            this.logger.doLog("Umfang wurde abgefragt.");
        }
        return this.umfang;
    }
  
  
    printInfo() {
      super.printInfo();
      console.log("Umfang: " + this.umfang);
    }
}	