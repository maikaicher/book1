package Kap15.Java.Listing06;

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
      byte[] myBuffer = new byte[noOfBytes];
      int readBytes = 0;
      try (FileInputStream fis = new FileInputStream(myFile)){
        readBytes = fis.read(myBuffer, 0, noOfBytes);
      }
      for (int i = 0; i < readBytes; i++) {
        System.out.println(Integer.toHexString(myBuffer[i]));
      }
    }
    
    
}