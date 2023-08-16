package Kap17.Java.Listing13_16;

import java.util.Arrays;

public class CompareExample {
    public static void main(String[] args) {
        Person[] personen = new Person[4];
        personen[0] = new Person("Peter", 182);
        personen[1] = new Person("Maria", 167);
        personen[2] = new Person("Hannah", 175);
        personen[3] = new Person("Andi", 170);
            
        Arrays.sort(personen);
        for (Person person : personen) {
            person.printInfo();
        }
    }
}
