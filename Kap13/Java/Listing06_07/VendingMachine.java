
public class VendingMachine {
    public static void main(String[] args) {
        VendingMachine v0 = new VendingMachine (new int[] {45, 29, 33});
        VendingMachine v1 = new VendingMachine (new int[] {10, 32, 28});
      
        for (int i = 0; i < 100; i++) {
          String vendResult = v0.getCan(1, 1.0);
          System.out.println("Rückgabe: " + vendResult);
        }
      }
      
    private int[] canCount;

    public VendingMachine(int[] initCanCount) {
        canCount = initCanCount;
    }

    public String getCan(int selection, double coin) {
      String output = "";	
      if(canCount[selection] == 0) {
        output = coin + " leer";
      } else {
        if (coin!= 1) {
            output = String.valueOf(coin);
        } else {
          canCount[selection]--;
          switch(selection) {
            case 0:
              output = "Wasser"; 
              break;
            case 1:
              output = "Limonade"; 
              break;
            case 2:
              output = "Cola"; 
              break;
          }
       }
    }
    return output;
  }
}
