<?php
  $ar = array(1, 2, 3);
  foreach ($ar as &$i) {
    $i++;
  }
  foreach ($ar as &$i) {
    echo "\n" .$i;
  }
  unset($i);
?>
