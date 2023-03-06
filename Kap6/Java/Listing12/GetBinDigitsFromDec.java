public class GetBinDigitsFromDec {
    public static void main(String[] args) {
        int basis = 2;
        int i = 324;
        do {
        int ziffer = i % basis;
        System.out.print(ziffer);
        i = i - ziffer;
        i = i / basis;
        } while (i != 0); 
    }
}