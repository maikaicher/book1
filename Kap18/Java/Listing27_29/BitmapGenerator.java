package Kap18.Java.Listing27_29;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

class BitmapGenerator {
    public static byte[] prepareBmp(int[][] pixel) {
        byte[] head = {
            0x42, 0x4d,             // ASCII für BM 
            0x00, 0x00, 0x00, 0x00, // Dateigröße
            0x00, 0x00, 0x00, 0x00, // immer 00
            0x36, 0x00, 0x00, 0x00, // Offset Bilddaten
            0x28, 0x00, 0x00, 0x00, // Größe Infoheader
            0x00, 0x00, 0x00, 0x00, // Breite
            0x00, 0x00, 0x00, 0x00, // Höhe
            0x01, 0x00,             // immer 01 00 
            0x18, 0x00,             // Farbtiefe
            0x00, 0x00, 0x00, 0x00, // keine Komprimierung
            0x00, 0x00, 0x00, 0x00, // Größe Bilddaten
            0x00, 0x00, 0x00, 0x00, // Auflösung horizontal - Standard 00
            0x00, 0x00, 0x00, 0x00, // Auflösung vertikal - Standard 00
            0x00, 0x00, 0x00, 0x00, // Farbtabelleninfo – Standard 00
            0x00, 0x00, 0x00, 0x00  // Farbtabelleninfo – Standard 00
        };

        if (pixel.length == 0) {
            return null;
        } 
        if (pixel[0].length == 0) {
            return null;
        }
        
        int height = pixel.length;
        int width = pixel[0].length;
        int noOfZero = (4 - ((3*width) % 4)) % 4;
    
        int noOfImgBytes = height * (3*width + noOfZero);
        int fileSize = head.length + noOfImgBytes;
        if (!setBytesLittleEnd(2, fileSize, head)) { return null;}
        if (!setBytesLittleEnd(18, width, head)) { return null;}
        if (!setBytesLittleEnd(22, height, head)) { return null;}
        if (!setBytesLittleEnd(34, noOfImgBytes, head)) { return null;}
    
        byte[] data = new byte[fileSize];
        int pos = 0;
        for (int i = 0; i < head.length; i++) {
          data[pos++] = (byte)head[i];
        }
        for (int r = 0; r < height; r++) {
          for (int c = 0; c < width; c++) {
            setBytesLittleEnd(pos, pixel[r][c], data);
            pos += 3;
          }
          for (int c = 0; c < noOfZero; c++) {
            data[pos++] = 0x00;
          }
        }
        return data;
      }
    

    public static boolean setBytesLittleEnd (int offset, int value, byte[] allBytes) {
        byte writeValue;
        while(value > 0) {
            writeValue = (byte)(value & 0xff);
            allBytes[offset++] = writeValue;
            value >>= 8;
            if (offset >= allBytes.length) {
                return false;
            }
        }
        return true;
    }  

    public static boolean writeAllBytes(String fileName, byte[] data) {
        FileOutputStream fos = null;
        try {
            File myFile = new File(fileName);
            if (myFile.exists()) {
                System.out.println("File will be overwritten!");
            }
            fos = new FileOutputStream(myFile, false);
            fos.write(data);
            fos.flush();
        } catch (IOException e1) {
            return false;
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    return false;
                }
            }
        }
        return true;
    }
}