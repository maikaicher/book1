public class GetBitFloatsFromDec {
    public static void main(String[] args) {
        int basis = 2;
        float f = 0.875f;
        do {
            f = f * basis;
            int ziffer = (int)f;
            System.out.print(ziffer);
            f = f - ziffer;
        } while (f != 0);  
    }
}