public class StrCompare1 {
    public static void main(String[] args) {
        String stringVar = "hallo ";
        String stringVarW = "welt";
        String stringVarM = "mars";
        
        //String string1 = "hallo welt";
        //String string2 = "hallo welt";
        String string1 = stringVar + stringVarW;
        String string2 = stringVar + stringVarW;
        String string3 = stringVar + stringVarM;
        System.out.println(string1 == string2);
        System.out.println(string1 == string3);
    }
}
    