<?php
    // inhalt sub2.php
    include "sub1.php";
    function doSumAndPrint($a, $b) {
        $result = doSum($a, $b);
        echo $result;
        return $result;
    }
?>