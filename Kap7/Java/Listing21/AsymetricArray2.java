public class AsymetricArray2 {
    public static void main(String[] args) {
        int[][] zahlArray = new int[3][];
        zahlArray[0] = new int [4];
        zahlArray[1] = new int [3];
        zahlArray[2] = new int [5];
        System.out.println("Gesamtlänge: " + zahlArray.length);
        System.out.println("Breite bei 0: " + zahlArray[0].length);
        System.out.println("Breite bei 1: " + zahlArray[1].length);
        System.out.println("Breite bei 2: " + zahlArray[2].length);        
    } 
}