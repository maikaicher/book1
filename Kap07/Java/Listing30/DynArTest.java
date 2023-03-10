import java.util.*;

public class DynArTest {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<String>();
        myList.add("ich");
        myList.add("gehe");
        myList.add("einkaufen");
        
        System.out.println("Wert auf Position 2: " + myList.get(2));
        myList.add(1, "heute");
        System.out.println("Wert auf Position 2: " + myList.get(2));
    }
}
    