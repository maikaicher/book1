public class SubStrExample {
    public static void main(String[] args) {
        String stringVar = "hallo welt";
        char[] stringVarArray = stringVar.toCharArray();
        char[] subStringArray = new char[5];
        for (int i = 0; i < 5; i++) {
        subStringArray[i] = stringVarArray[i];
        }
        String subStringVar = new String(subStringArray);
        System.out.println(subStringVar);
    }
}
    