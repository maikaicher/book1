package Kap16.Java.Listing12;

import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class XmlSaxParser extends DefaultHandler {
  public static void main(String[] args) throws Exception{
    SAXParserFactory spf = SAXParserFactory.newInstance();
    SAXParser saxParser = spf.newSAXParser();
    XMLReader xmlReader = saxParser.getXMLReader();
    xmlReader.setContentHandler(new XmlSaxParser());
    xmlReader.parse("C:\\temp\\Persons2.xml");
  }

  public void startDocument() throws SAXException {
    System.out.println("start parsing document");
  }

  public void endDocument() throws SAXException {
    System.out.println("done parsing document");
  }

  public void startElement(String namespaceURI, String localName, String qName,
      Attributes atts) throws SAXException {
    System.out.println("found Element " + localName);
    for (int i = 0; i < atts.getLength(); i++) {
      String attrName = atts.getLocalName(i);
      System.out.println("Attribute " + attrName + " contains " +
         atts.getValue(attrName));
    }
  }
  
  public void endElement(String namespaceURI, String localName, String qName)  
     throws SAXException {
    System.out.println("end of Element " + localName);
  }

  public void characters(char[] ch, int start, int length) throws SAXException {
    System.out.println("Content found: " + new String(ch, start, length));
  }

  public void warning(SAXParseException e) throws SAXException {
    System.out.println("Warning occurred.");
    throw new SAXException(e.getMessage());
  }
        
  public void error(SAXParseException e) throws SAXException {
    System.out.println("Error occurred.");
    throw new SAXException(e.getMessage());
  }

  public void fatalError(SAXParseException e) throws SAXException {
    System.out.println("Fatal Error occurred.");
    throw new SAXException(e.getMessage());
  }
}
