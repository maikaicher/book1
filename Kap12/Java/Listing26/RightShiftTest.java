package Kap12.Java.Listing26;

public class RightShiftTest {

	public static void main(String[] args) {
		int s = -3254;
		System.out.println(Integer.toBinaryString(s));
		s >>>= 3;
		System.out.println(Integer.toBinaryString(s));
		System.out.println(s);
	}
}
