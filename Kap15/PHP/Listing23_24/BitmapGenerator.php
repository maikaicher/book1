<?php

$height = 512; // 3 
$width = 1024; // 3 
$body = genBmpData($height, $width, 0xe9967a);
$data = prepareBmp($body, $height, $width);

$binData = null;
foreach ($data as $byte) {
  $binData .= pack("C", $byte); 
  //$binData .= $byte; // Alternative for Listing 24 
}

$fp = fopen("C:\\temp\\NewBitmapPhp.bmp", "w");
fwrite($fp, $binData);
fclose($fp);


function genBmpData($height, $width, $color) {
    $colB = $color & 0xff;
    $colG = ($color >> 8) & 0xff;
    $colR = ($color >> 16) & 0xff;
    $noOfZero = (4 - ((3 * $width) % 4)) % 4;
    $body = array();
    for ($r = 0; $r < $height; $r++) {
        $pos = 0;
        for ($c = 0; $c < $width; $c++) {
            $body[$r][$pos++] = $colB;
            $body[$r][$pos++] = $colG;
            $body[$r][$pos++] = $colR;
        }
        for ($c = 0; $c < $noOfZero; $c++) {
            $body[$r][$pos++] = 0x00;
        }
    }
    return $body;
}

function setBytesLittleEnd ($offset, $value, &$allBytes) {
    $writeValue = 0;
    while($value > 0) {
        $writeValue = $value & 0xff;
        $allBytes[$offset++] = $writeValue;
        $value >>= 8;
        if ($offset >= count($allBytes)) {
            return false;
        }
    }
    return true;
}  

function prepareBmp($body, $height, $width) {
    $head = array(
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
    );
    if (count($body) == 0) {
        return null;
    } 
    if (count($body[0]) == 0) {
        return null;
    }
    $noOfImgBytes = count($body) * count($body[0]);
    $fileSize = count($head) + $noOfImgBytes;

    if (!setBytesLittleEnd(2, $fileSize, $head)) { return null;}
    if (!setBytesLittleEnd(18, $width, $head)) { return null;}
    if (!setBytesLittleEnd(22, $height, $head)) { return null;}
    if (!setBytesLittleEnd(34, $noOfImgBytes, $head)) { return null;}
    $data = array();
    $pos = 0;
    for ($i = 0; $i < count($head); $i++) {
        $data[$pos++] = $head[$i];
    }
    for ($r = 0; $r < count($body); $r++) {
        for ($c = 0; $c < count($body[$r]); $c++) {
            $data[$pos++] = $body[$r][$c];
        }
    }
    return $data;
}
?>