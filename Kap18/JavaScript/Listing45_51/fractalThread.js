class ComplexNumber {
    constructor(re, im) {
      this.re = re;
      this.im = im;
    }
    square() {
      let r = this.re * this.re - this.im * this.im;
      let i = 2 * this.re * this.im;
      this.re = r;
      this.im = i;
    }
    getDistSquare() {
      return this.re * this.re + this.im * this.im;
    }
    addC(re, im) {
      this.re += re;
      this.im += im;
    }
    reset() {
      this.re = 0; 
      this.im = 0;
    } 
  }
  
  function calcPixel(data) {
    let config = JSON.parse(data);
    let pixel = Array(config.dimY);
    let z = new ComplexNumber(0, 0);
    let delta = 0xffffff / 2500;
    for (let r = config.rFrom; r < config.rTo; r++) {
      pixel[r] = Array(config.dimX);
      for (let c = 0; c < config.dimX; c++) {
        pixel[r][c] = 0;
        z.reset();
        let posX = config.startRe - (config.halfDimRe - c) * config.pixelDist;
        let posY = -1*(config.startIm - (config.halfDimIm - r) * config.pixelDist);
        for (let i = 0; i < config.maxIteration; i++) {
          z.square();
          z.addC(posX, posY);
          if (z.getDistSquare() > config.thresSquare) {
            pixel[r][c] = Math.floor(i * delta);
            break;
          }
        }
      }
    }
    let graphicData = {
      rFrom:config.rFrom,
      rTo:config.rTo,
      dimX:config.dimX,
      dimY:config.dimY,
      pixel:pixel
    };

    let jsonData = JSON.stringify(graphicData);
    if (config.sendMessage) {
        self.postMessage(jsonData);
    } else {
      return jsonData;
    }
  }
  
  // hier wird der Thread aufgerufen
  self.addEventListener('message', function(e) {
    calcPixel(e.data);
  });
  