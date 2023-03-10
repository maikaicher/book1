import java.util.*;

public class ArrayConstantPos {
    public static void main(String[] args) {
        final int IP = 0;
        final int PORT = 1;
        final int DB_TYPE = 2;	
        String[] cfgValues = {"127.0.0.1", "3306", "MYSQL"};
        System.out.println("Cnct: " + cfgValues[IP] + ":" + cfgValues[PORT]);
    }
}
    