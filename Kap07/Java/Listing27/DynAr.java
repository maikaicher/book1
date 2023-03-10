import java.util.*;

public class DynAr {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<String>();
        myList.add("a");
        myList.add("b");
        myList.add("c");
        myList.add("e");
        myList.add("X");
        myList.add("F");
    
        System.out.println("Wert auf Position 1: " + myList.get(1));
        myList.add(3, "d");
        myList.remove(5);
        myList.set(5, "f");
    
        for (int i = 0; i < myList.size(); i++) {
            System.out.println("Wert pos " + i + ": "  + myList.get(i));
        }
    }
}
    