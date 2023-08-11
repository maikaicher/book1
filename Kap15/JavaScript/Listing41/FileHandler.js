const fs = require('fs');

readText("C:\\temp\\Hello.txt");
writeText("C:\\temp\\Hello9.txt", "Hallo, Welt!\nDie 1. Zeile hat zwölf Zeichen.");

function readText(fName) {
    var content = fs.readFileSync(fName, {encoding:'utf8', flag:'r'});
    console.log(content);
}
  
function writeText(fName, content) {
    fs.writeFileSync(fName, content, {encoding:'utf8', flag:'w'})
}
  