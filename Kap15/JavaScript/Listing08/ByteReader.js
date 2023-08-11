const fs = require('fs');

function readBytes(fName, noOfBytes) {
    const myBuffer = Buffer.alloc(noOfBytes);
    let readBytes = 0;
    fs.open(fName, 'r', function(err, fp) {
      if (err) {
        console.log(err); 
      } else {
        readBytes = fs.readSync(fp, myBuffer, 0, noOfBytes, null);   
        for (let i = 0; i < readBytes; i++) {
          console.log(myBuffer[i].toString(16));
        }
      }
    });
  }
  
  readBytes("C:\\temp\\MyBitmap.bmp", 100);