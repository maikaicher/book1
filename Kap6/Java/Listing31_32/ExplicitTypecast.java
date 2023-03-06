public class ExplicitTypecast {
    public static void main(String[] args) {
        int i = 10;
        // short s = i;  // this would produce an error
        short s = (short) i;
        System.out.println(s);        
   }
}