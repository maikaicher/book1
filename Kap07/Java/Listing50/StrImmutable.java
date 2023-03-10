public class StrImmutable {
    public static void main(String[] args) {
        String stringVar  = "hallo welt";
        System.out.println(System.identityHashCode(stringVar) );
        stringVar += "";
        System.out.println(System.identityHashCode(stringVar) );
    }
}
    