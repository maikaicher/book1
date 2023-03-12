public class CallBehaviour {
    public static void main(String[] args){
        int iVal = 0;
        int[] iArVal = {0};
        incValue(iVal);
        incValue(iArVal);
        System.out.println("Ref 3: " + iVal);
        System.out.println("Ref 4: " + iArVal[0]);
      }
          
      public static void incValue(int iValPar) {
        iValPar++;
        System.out.println("Ref 1: " + iValPar);
      }
          
      public static void incValue(int[] iArValPar) {
        iArValPar [0]++;
        System.out.println("Ref 2: " + iArValPar [0]);
      }      
}