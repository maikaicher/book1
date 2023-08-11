using System.Text;

File.WriteAllLines("C:\\temp\\Hello7.txt", new String[] {"Hallo, Welt!", "Die 1. Zeile hat zwölf Zeichen."}, Encoding.UTF8);

String myLines = File.ReadAllText("C:\\temp\\Hello.txt", Encoding.UTF8);
Console.WriteLine(myLines);
