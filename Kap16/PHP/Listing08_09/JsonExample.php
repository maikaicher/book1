<?php
readJson("C:\\temp\\Persons2.json");

function readJson($fName) {
  $fp = fopen($fName, "r");
  $content = fread($fp, filesize($fName));
  fclose($fp);
  $jsonObjects = json_decode($content);
  echo print_r($jsonObjects); 
}



class Person {
    public $Vorname;
    public $Alter; 
    function __construct($Vorname, $Alter) {
      $this->Vorname = $Vorname;
      $this->Alter = $Alter;
    }
}
  
class MyData {
    public $letzteAnpassung;
    public $AdressDaten = array();
}
  
function printJson() {
    $person1 = new Person("Peter", 20);
    $person2 = new Person("Maria", 20);
    $myInfos = new MyData();
    $myInfos->letzteAnpassung = "10.02.2022";
    $myInfos->AdressDaten[0] = $person1;
    $myInfos->AdressDaten[1] = $person2;
    echo json_encode($myInfos);
}
  
printJson();

?>