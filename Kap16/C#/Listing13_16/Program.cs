Adressbuch myAddr = new Adressbuch("10.02.2022");
myAddr.Adressen.Add(new PersonClass("Peter", 20, "m"));
myAddr.Adressen.Add(new PersonClass("Maria", 19, "w"));
Console.WriteLine(myAddr.getXmlString());
