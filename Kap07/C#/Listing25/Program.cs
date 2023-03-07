int[,] zahlArray =  {{11, 12}, {21, 22}, {31, 32}};
Console.WriteLine("Gesamtlänge: " + zahlArray.Length);
Console.WriteLine("Höhe: " + zahlArray.GetLength(0));
Console.WriteLine("Breite: " + zahlArray.GetLength(1));
Console.WriteLine("wert bei 0/0: " + zahlArray[0,0]);
Console.WriteLine("Wert bei 2/1: " + zahlArray[2,1]);
