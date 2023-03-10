import java.math.BigDecimal;

public class FixedPointExample {
    public static void main(String[] args) {
        BigDecimal myDecA = new BigDecimal(4);
        BigDecimal myDecB = new BigDecimal(1);
        BigDecimal myDiv = new BigDecimal(10);
        myDecA = myDecA.divide(myDiv);
        myDecB = myDecB.divide(myDiv);
        System.out.println(myDecA.multiply(myDecB));
   }
}