public class ForEach {
    public static void main(String[] args) {
        int[][] ar = {{1, 1}, {2, 2}, {3, 3}};
        for (int[] i : ar) {
          i[0]++;
        }
        for (int[] i : ar) {
          System.out.println(i[0]);
        }        
    }    
}
