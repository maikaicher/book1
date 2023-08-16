<?php
    $primes = getPrimes(100000);
   
    function getPrimes($maxVal) {
        $start = floor(microtime(true) * 1000);
        $primes = array();
                    
        for ($i = 2; $i <= $maxVal; $i++) {
            $isPrime = TRUE;
            for ($d = 2; $d < $i; $d++) {
                if ($i%$d == 0) {
                    $isPrime = FALSE;
                }
            } 
            if ($isPrime) {
                array_push($primes, $i);
            }
        }

        echo (floor(microtime(true) * 1000) - $start);
        return $primes;
    }

?>