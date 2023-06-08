<?php
include "MyLogger.php";
include "MyGraphs.php";


$myD = new \mygraphs\Dreieck(0x000000, 0xff0000, 3.0, 2.0, 2.0);
$logger1 = new \mylogger\MyJsonLogger();
$myD->registerLogger($logger1);

$myK = new \mygraphs\Kreis(0x000000, 0xff0000, 3.0);
$logger2 = new \mylogger\MyPlainLogger();
$myK->registerLogger($logger2);

echo "\n" .$myD->getUmfang();
echo "\n" .$myK->getUmfang();


?>