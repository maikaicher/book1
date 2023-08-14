using System.Xml;

class DomParser {
    static public void readXml(string fileName) {
        XmlDocument theDocument = new XmlDocument();
        theDocument.Load(fileName);
        XmlNode rootNode = theDocument.FirstChild;
        readChildNodes(rootNode);
    }

    static public void readChildNodes(XmlNode parentNode) {
        if (parentNode.Attributes != null) {
            foreach (XmlAttribute attr in parentNode.Attributes) {
            Console.WriteLine(parentNode.Name + " has Attribute " + attr.Name + " with Value " + attr.Value);
            }
        }
        if (parentNode.HasChildNodes) {
            foreach(XmlNode childNode in parentNode) {
            readChildNodes(childNode);
            }
        } else {
            Console.WriteLine(parentNode.ParentNode.Name + " has Value " + parentNode.InnerText);
        }
    }
}