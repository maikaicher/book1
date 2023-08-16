package Kap17.Java.Listing13_16;

public class Person implements Comparable {
    private String name;
    private int groesse;

    public Person(String name, int groesse) {
        this.name = name;
        this.groesse = groesse;
    }

    public void printInfo() {
        System.out.println(name + ": " + groesse);
    }

    // Listing 15:
    @Override
    public int compareTo(Object o) {
        if (this.groesse > ((Person)o).groesse) {
            return 1;
        }
        if (this.groesse < ((Person)o).groesse) {
           return -1;
        }
        return 0;
    }   

    // Listing 16:
    /* 
    @Override
    public int compareTo(Object o) {
        return this.name.compareTo(((Person)o).name);
    }   
    */
} 

