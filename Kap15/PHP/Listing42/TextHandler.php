<?php

readText("C:\\temp\\Hello.txt");

writeText("C:\\temp\\Hello10.txt", "Hallo, Welt!\nDie 1. Zeile hat zwölf Zeichen.");

function readText($fName) {
    $fp = fopen($fName, "r");
    echo fread($fp, filesize($fName));
    fclose($fp);
  }
  
function writeText($fName, $content) {
    $fp = fopen($fName, "w");
    fwrite($fp, $content);
    fclose($fp);
}
  
?>