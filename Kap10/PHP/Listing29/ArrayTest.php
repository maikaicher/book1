<?php
  $myArr = array("a", "b", "c", "e", "X", "F");
  echo "Wert auf Position 1: " .$myArr[1];
  array_splice($myArr, 3, 0, "d");
  array_splice($myArr, 5, 1);
  $myArr[5] = "f";
  for ($i = 0; $i < count($myArr); $i++) {
    echo "\nWert pos: " .$i .": " .$myArr[$i];
  }
?>
