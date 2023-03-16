<?php
  $iVal = 0;
  $iArVal = array(0);
  incIval($iVal);
  incIArVal($iArVal);
  echo "\nRef 3: " .$iVal;
  echo "\nRef 4: " .$iArVal[0];

  function incIVal($iVal) {
    $iVal++;
    echo "\nRef 1: " .$iVal;
  }
  function incIArVal($iArVal) {
    $iArVal[0]++;
    echo "\nRef 2: " .$iArVal[0];
  }
?>