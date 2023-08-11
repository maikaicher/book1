public class ForEach {
    public static void main(String[] args) {
        int[] ar = {1, 2, 3};
        for (int i : ar) {
            i++;
        }
        for (int i : ar) {
            System.out.println(i);
        }
    }    
}
