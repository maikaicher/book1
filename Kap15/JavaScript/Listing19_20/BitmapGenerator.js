import * as fs from 'fs';
var height = 512;
var width = 1024;
var body = genBmpData(height, width, 0xe9967a);
var data = prepareBmp(body, height, width);

fs.writeFile("C:\\temp\\NewBitmapJs.bmp", data, "binary", function(err) {
  if (err) {
     console.log(err);
  } else {
     console.log("Datei wurde geschrieben!");
  }
});


function genBmpData(height, width, color) {
    const colB = color & 0xff;
    const colG = (color >> 8) & 0xff;
    const colR = (color >> 16) & 0xff;
    const noOfZero = (4 - ((3 * width) % 4)) % 4;
    const body = Array.from(Array(height), () => new Array(3*width + noOfZero));
    for (let r = 0; r < height; r++) {
        let pos = 0;
        for (let c = 0; c < width; c++) {
            body[r][pos++] = colB;
            body[r][pos++] = colG;
            body[r][pos++] = colR;
        }
        for (let c = 0; c < noOfZero; c++) {
            body[r][pos++] = 0x00;
        }
    }
    return body;
}

function setBytesLittleEnd (offset, value, allBytes) {
    let writeValue;
    while(value > 0) {
        writeValue = value & 0xff;
        allBytes[offset++] = writeValue;
        value >>= 8;
        if (offset >= allBytes.length) {
            return false;
        }
    }
    return true;
}  

function prepareBmp(body, height, width) {
    const head = [
        0x42, 0x4d,             // ASCII für BM 
        0x00, 0x00, 0x00, 0x00, // Dateigröße
        0x00, 0x00, 0x00, 0x00, // immer 00
        0x36, 0x00, 0x00, 0x00, // Offset Bilddaten
        0x28, 0x00, 0x00, 0x00, // Größe Infoheader
        0x00, 0x00, 0x00, 0x00, // Breite
        0x00, 0x00, 0x00, 0x00, // Höhe
        0x01, 0x00,             // immer 01 00 
        0x18, 0x00,             // Farbtiefe
        0x00, 0x00, 0x00, 0x00, // keine Komprimierung
        0x00, 0x00, 0x00, 0x00, // Größe Bilddaten
        0x00, 0x00, 0x00, 0x00, // Auflösung horizontal - Standard 00
        0x00, 0x00, 0x00, 0x00, // Auflösung vertikal - Standard 00
        0x00, 0x00, 0x00, 0x00, // Farbtabelleninfo – Standard 00
        0x00, 0x00, 0x00, 0x00  // Farbtabelleninfo – Standard 00
    ];
    if (body.length == 0) {
        return null;
    } 
    if (body[0].length == 0) {
        return null;
    }
    const noOfImgBytes = body.length * body[0].length;
    const fileSize = head.length + noOfImgBytes;
    if (!setBytesLittleEnd(2, fileSize, head)) { return null;}
    if (!setBytesLittleEnd(18, width, head)) { return null;}
    if (!setBytesLittleEnd(22, height, head)) { return null;}
    if (!setBytesLittleEnd(34, noOfImgBytes, head)) { return null;}
    let data = new Buffer.alloc(fileSize);
    let pos = 0;
    for (let i = 0; i < head.length; i++) {
        data[pos++] = head[i];
    }
    for (let r = 0; r < body.length; r++) {
        for (let c = 0; c < body[r].length; c++) {
            data[pos++] = body[r][c];
        }
    }
    return data;
}