<?php
namespace mygraphs;


interface Jsonifyable {
  public function getJsonString();
}

abstract class GrafikElm {
    protected $randfarbe;
    protected $logger = null;

    public function __construct($initRandfarbe) {
        $this->randfarbe = $initRandfarbe;
        echo "\nGrafikElm erzeugt.";
    }

    public function registerLogger($logger) {
      $this->logger = $logger;
    }

    public function getRandfarbe() {
      return $this->randfarbe;
    }
    public function setRandfarbe($newRandfarbe) {
      $this->randfarbe = $newRandfarbe;
    }
    public function printInfo() {
      echo "\nRandfarbe: " .$this->randfarbe;
    }
}

abstract class FlaechenElm extends GrafikElm {
  protected $fuellfarbe;
  protected $flaeche = 0;
   
  public function __construct($initRandfarbe, $initFuellfarbe) {
    parent::__construct($initRandfarbe);
    $this->fuellfarbe = $initFuellfarbe;
    echo "\nFlaechenElm erzeugt.";
  }
 
  abstract protected function berechneFlaeche();

  public function getFuellfarbe() {
    return $this->fuellfarbe;
  }

  public function setFuellfarbe($newFuellfarbe) {
    $fuellfarbe = $newFuellfarbe;
  }

  public function getFlaeche() {
    return $this->flaeche;
  }
  public function printInfo() {
    parent::printInfo();
    echo "Fuellfarbe: " .$fthis->uellfarbe;
    echo "Flaeche: " .$this->flaeche;
  }
}

abstract class ZweiDElm extends FlaechenElm {
  protected $umfang = 0;
   
  public function __construct($initRandfarbe, $initFuellfarbe) {
    parent::__construct($initRandfarbe, $initFuellfarbe);
    echo "\nZweiDElm erzeugt.";
  }
 
  abstract protected function berechneUmfang();

  public function getUmfang() {
    if ($this->logger != null) {
      $this->logger->doLog("Umfang wurde abgefragt.");
    }
    return "\n" .$this->umfang;
  }


  public function printInfo() {
    parent::printInfo();
    echo "\nUmfang: " .$this->umfang;
  }
}	

class Kreis extends ZweiDElm {
    protected $radius;
     
    public function __construct($initRandfarbe, $initFuellfarbe, $radius) {
      parent::__construct($initRandfarbe, $initFuellfarbe);
      $this->radius = $radius;
      $this->berechneUmfang();
      $this->berechneFlaeche();
      echo "\nKreis erzeugt.";
    }
    
    protected function berechneUmfang() {
      $this->umfang = 2*$this->radius * M_PI;
    }

    protected function berechneFlaeche() {
      $this->flaeche = $this->radius * $this->radius * M_PI;
    }

    public function setRadius($radius) {
        $this->radius = $radius;
    }
    
    public function getRadius() {
      return radius;
    }

      public function printInfo() {
      parent::printInfo();
      echo "\nRadius: " .$this->radius;
    }
}

class Rechteck extends ZweiDElm implements Jsonifyable {
  private $laenge;
  private $breite;
   
  public function __construct($initRandfarbe, $initFuellfarbe, $laenge, $breite) {
    parent::__construct($initRandfarbe, $initFuellfarbe);
    $this->laenge = $laenge;
    $this->breite = $breite;
    $this->berechneUmfang();
    $this->berechneFlaeche();
    System.out.println("Rechteck erzeugt.");
  }

  public function getJsonString() {
    $jsonRep = 
      "{\"Typ: \":\"Rechteck\""
      .",\n\"Randfarbe\":" .randfarbe
      .",\n\"Fuellfarbe\":" .fuellfarbe
      .",\n\"Umfang\":" .umfang
      .",\n\"Flaeche\":" .flaeche
      .",\n\"Laenge\":" .laenge
      .",\n\"Breite\":" .breite ."}";
    return jsonRep;
  }

  protected function berechneUmfang() {
    $this->umfang = 2*$this->laenge + 2*$this->breite;
  }

  protected function berechneFlaeche() {
    $this->flaeche = $this->laenge * $this->breite;
  }

  public function getLaenge() {
    return $this->laenge;
  }
    
  public function setLaenge($laenge) {
      $this->laenge = $laenge;
  }

    public function getBreite() {
      return $this->breite;
    }
    
    public function setBreite($breite) {
      $this->breite = $breite;
    }
  
  public function printInfo() {
    parent::printInfo();
    echo "\nLaenge: " . $this->laenge;
    echo "\nBreite: " . $this->breite;
  }
}

final class Dreieck extends ZweiDElm {
  private $seiteA = 1;
  private $seiteB = 1;
  private $seiteC = 1;

    public function __construct($initRandfarbe, $initFuellfarbe, $a, $b, $c) {
      parent::__construct($initRandfarbe, $initFuellfarbe);
      echo "\nStart Konstruktor Dreieck";
      if ($this->checkValues($a, $b, $c)) {
        $this->seiteA = $a;
        $this->seiteB = $b;
        $this->seiteC = $c;
        $this->berechneFlaeche();        
      }
      echo "\nEnde Konstruktor Dreieck";
    }
    
    private function checkValues($a, $b, $c) {
      if ($a + $b <= $c || $b + $c <= $a || $c + $a <= $b) {
        return false;
      }
      return true;
    }

    protected function berechneUmfang() {
      $this->umfang = $this->seiteA + $this->seiteB + $this->seiteC;
    }

    protected function berechneFlaeche() {
      $this->berechneUmfang();
        $s = $this->umfang/2;
        $this->flaeche = sqrt($s * ($s - $this->seiteA) * ($s - $this->seiteB) * ($s - $this->seiteC));
    }

    public function getSeiteA() {
      return $this->seiteA;
    }
    
    public function setSeiteA($a) {
      if (checkValues($a, $this->seiteB, $this->seiteC)) {
        $this->seiteA = $a;
        $this->berechneFlaeche();
      }
    }
    public function getSeiteB() {
      return $this->seiteB;
    }
    
    public function setSeiteB($b) {
      if (checkValues($this->seiteA, $b, $this->seiteC)) {
        $this->seiteB = $b;
        $this->berechneFlaeche();
      }
    }
    public function getSeiteC() {
      return $this->seiteC;
    }
    
    public function setSeiteC($c) {
      if (checkValues($this->seiteA, $this->seiteB, $c)) {
        $this->seiteC = $c;
        $this->berechneFlaeche();
      }
    }
    
    public function printInfo() {
      parent::printInfo();
      echo "\nSeite A: " + $this->seiteA;
      echo "\nSeite B: " + $this->seiteB;
      echo "\nSeite C: " + $this->seiteC;
   }
  
}

?>