public class PersonClass : XmlExtractable {
  public String Vorname {get;set;}
  public int Alter {get;set;}
  public String Geschlecht {get;set;}
  public PersonClass(String Vorname, int Alter, String Geschlecht) {
    this.Vorname = Vorname;
    this.Alter = Alter;
    this.Geschlecht = Geschlecht;
  }

  public String getXmlString() {
    return "<Person geschl=\"" + Geschlecht + "\"><Vorname>" + Vorname +
      "</Vorname><Alter>" + Alter + "</Alter></Person>";
  }
}
