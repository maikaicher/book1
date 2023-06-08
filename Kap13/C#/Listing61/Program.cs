
MyArrayList<string> myList = new MyArrayList<string>();
myList.add("a");
myList.add("b");
myList.add("c");
myList.add("e");
myList.add("X");
myList.add("F");

Console.WriteLine("Wert auf Position 1: " + myList.get(1).ToUpper());
myList.add(3, "d");
myList.remove(5);
myList.set(5, "f");

for (int i = 0; i < myList.getSize(); i++) {
    Console.WriteLine("Wert pos " + i + ": "  + myList.get(i));
}

