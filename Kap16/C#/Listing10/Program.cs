using System.Text.Json;

List<PersonClass> persons = new List<PersonClass>();
persons.Add(new PersonClass("Peter", 20));
persons.Add(new PersonClass("Maria", 19));
Console.WriteLine(JsonSerializer.Serialize(persons));
