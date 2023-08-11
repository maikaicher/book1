package Kap15.Java.Listing05;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteReader {
    public static void main(String[] args) {
        try {
          ByteReader.printBytes("C:\\temp\\MyBitmap.bmp", 100);
        } catch (IOException e) {
          e.printStackTrace();
        }
    }
    
    public static void printBytes(String fName, int noOfBytes) throws IOException {
      File myFile = new File(fName);
      try (FileInputStream fis = new FileInputStream(myFile)) {
        int myByte = 0;
        while(noOfBytes-- > 0 && (myByte = fis.read()) != -1) {
          System.out.println(Integer.toHexString(myByte));
        }
      }
    }
    
}