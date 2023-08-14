using System.Text.Json;
// Listing 05
String jsonString = File.ReadAllText("C:\\temp\\Persons.json");
List<PersonClass> persons =
    JsonSerializer.Deserialize<List<PersonClass>>(jsonString);
Console.WriteLine(persons[0].Vorname);
Console.WriteLine(persons[1].Alter);


// Listing 07
String jsonString2 = File.ReadAllText("C:\\temp\\Persons2.json");
JsonDocument completeDom = JsonDocument.Parse(jsonString2);
JsonElement root = completeDom.RootElement;
JsonElement lastChange = root.GetProperty("letzteAnpassung");
Console.WriteLine("Letzte Anpassung: " + lastChange);
JsonElement adressData = root.GetProperty("AdressDaten");

for (int i = 0; i < adressData.GetArrayLength(); i++) {
  JsonElement adressObject = adressData[i];
  Console.WriteLine("Vorname: " + adressObject.GetProperty("Vorname"));
  Console.WriteLine("Alter: " + adressObject.GetProperty("Alter"));
}
