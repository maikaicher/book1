import java.util.Hashtable;

public class HashtableTest {
    public static void main(String[] args) {
        Hashtable<String, String> cfgValues = new Hashtable<String, String>();
        cfgValues.put("IP", "127.0.0.1");
        cfgValues.put("PORT", "3306");
        cfgValues.put("DBType", "MYSQL");
        System.out.println("Cnct: " + cfgValues.get("IP") + ":" + cfgValues.get("PORT"));
    }
}
    