using System.Text;

String[] myContent1 = {"Hallo, Welt!", "Die 1. Zeile hat 12 Zeichen."};
File.WriteAllLines("C:\\temp\\Hallo1.txt", myContent1, Encoding.ASCII);

String[] myContent2 = {"Hallo, Welt!", "Die 1. Zeile hat zwölf Zeichen."};
File.WriteAllLines("C:\\temp\\Hallo2.txt", myContent2, Encoding.ASCII);

String[] myContent3 = {"Hallo, Welt!", "Die 1. Zeile hat zwölf Zeichen."};
File.WriteAllLines("C:\\temp\\Hallo3.txt", myContent3, Encoding.Latin1);

String[] myContent4 = {"Hallo, Welt!", "Die 1. Zeile hat zwölf Zeichen."};
File.WriteAllLines("C:\\temp\\Hallo4.txt", myContent4, Encoding.UTF8);
