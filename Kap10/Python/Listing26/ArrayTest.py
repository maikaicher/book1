myList = ["a", "b", "c", "e", "X", "F"]; 
print("Wert auf Position 1: " + myList[1])
myList.insert(3, "d")
myList.pop(5)
myList[5] = "f";
for i in range(0, len(myList)):
    print("Wert pos: " + str(i) + ": " + myList[i])
