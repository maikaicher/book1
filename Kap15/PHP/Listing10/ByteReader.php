<?php
function readBytes($fName, $noOfBytes) {
  $fp = fopen($fName, "rb");
  if ($fp) {
    if ($noOfBytes > filesize($fName)) {
      $noOfBytes = filesize($fName);
    }
    $myBytes = fread($fp, $noOfBytes);
    fclose($fp);
    for($i = 0; $i < strlen($myBytes); $i++) {
      echo "\n" .dechex(ord($myBytes[$i]));
    }
  }
}

readBytes("C:\\temp\\MyBitmap.bmp", 100);
?>