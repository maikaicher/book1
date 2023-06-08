import Dreieck from "./mygraphs/Dreieck.mjs";
import Kreis from "./mygraphs/Kreis.mjs";
import MyJsonLogger from "./mylogger/MyJsonLogger.mjs";
import MyPlainLogger from "./mylogger/MyPlainLogger.mjs";

const myD = new Dreieck(0x000000, 0xff0000, 3.0, 2.0, 2.0);
const logger1 = new MyJsonLogger();
myD.registerLogger(logger1);

const myK = new Kreis(0x000000, 0xff0000, 3.0);
const logger2 = new MyPlainLogger();
myK.registerLogger(logger2);

console.log(myD.getUmfang());
console.log(myK.getUmfang());