package Kap15.Java.Listing04;

import java.io.File;
import java.io.FileInputStream;

public class ByteReader {
    public static void main(String[] args) {
        ByteReader.printBytes("C:\\temp\\MyBitmap.bmp", 100);
    }
    public static void printBytes(String fName, int noOfBytes) {
        FileInputStream fis = null;
        File myFile = new File(fName);
        try {
          fis = new FileInputStream(myFile);
          int myByte = 0;
          while(noOfBytes-- > 0 && (myByte = fis.read()) != -1) {
            System.out.println(Integer.toHexString(myByte));
          }
        } catch(Exception e) {
          System.out.println(e.getMessage());
        } finally {
          if (fis != null) {
            try {
              fis.close();
            } catch(Exception e) {
              System.out.println("close fail");
            }
          }
        }
      }      
}