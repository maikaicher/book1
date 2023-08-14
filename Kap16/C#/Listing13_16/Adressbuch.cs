public class Adressbuch : XmlExtractable {
  public String LetzteAnpassung {get;set;}
  public List<PersonClass> Adressen {get;set;}
  public Adressbuch(String letzteAnpassung) {
    this.LetzteAnpassung = letzteAnpassung;
    Adressen = new List<PersonClass>();
  }
  public String getXmlString() {
    String XmlString = "<IchBinDasRootTag><LetzteAnpassung>" + LetzteAnpassung +
       "</LetzteAnpassung><AdressDaten>";
    foreach (XmlExtractable element in Adressen) {
      XmlString += element.getXmlString();
    } 
    return XmlString + "</AdressDaten></IchBinDasRootTag>";
  }
}
