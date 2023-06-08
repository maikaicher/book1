<?php

namespace mylogger;

interface MyLogger {
    public function doLog($data);
}

class MyJsonLogger implements MyLogger {
    public function doLog($data) {
        echo "\n{\"message\":\"" .$data ."\"}";
    }
}

class MyPlainLogger implements MyLogger {
    public function doLog($data) {
        echo "\n" .$data;
    }
}

?>