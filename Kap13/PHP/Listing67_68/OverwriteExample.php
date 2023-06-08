<?php
    class MyClass {
        public function __construct($myParam) {
          echo "Constructor called with " .$myParam;
        }

        public function __call($myParam1, $myParam2) {
            echo "\nCalled Method: " .$myParam1 . "\n";
            print_r($myParam2);
          }
      }
      
      $myObj = new MyClass("123");
      $myObj->doSomething("hello");
?>