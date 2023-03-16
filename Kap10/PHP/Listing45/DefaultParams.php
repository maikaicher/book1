<?php
echo "\n" .doSum(1, 2);
echo "\n" .doSum(1, 2, 4);

function doSum($a, $b, $c = 0) {
    echo "\n3 params";
    return $a + $b + $c;
}
?>