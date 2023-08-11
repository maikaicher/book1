class BitmapGenerator {
    public static byte[,] genBmpData(int height, int width, int color) {
        byte colB = (byte)(color & 0xff);
        byte colG = (byte)((color >> 8) & 0xff);
        byte colR = (byte)((color >> 16) & 0xff);
        int noOfZero = (4 - ((3 * width) % 4)) % 4;
        byte[,] body = new byte[height,3 * width + noOfZero];
        for (int r = 0; r < height; r++) {
            int pos = 0;
            for (int c = 0; c < width; c++) {
                body[r,pos++] = colB;
                body[r,pos++] = colG;
                body[r,pos++] = colR;
            }
            for (int c = 0; c < noOfZero; c++) {
            body[r,pos++] = 0x00;
            }
        }
        return body;
    }

    public static bool setBytesLittleEnd (int offset, int value, byte[] allBytes) {
        byte writeValue;
        while(value > 0) {
            writeValue = (byte)(value & 0xff);
            allBytes[offset++] = writeValue;
            value >>= 8;
            if (offset >= allBytes.Length) {
            return false;
            }
        }
        return true;
    }  

    public static byte[] prepareBmp(byte[,] body, int height, int width) {
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
        if (body.GetLength(0) == 0) {
            return null;
        } 
        if (body.GetLength(1) == 0) {
            return null;
        }
        int noOfImgBytes = body.Length;
        int fileSize = head.Length + noOfImgBytes;
        if (!setBytesLittleEnd(2, fileSize, head)) { return null;}
        if (!setBytesLittleEnd(18, width, head)) { return null;}
        if (!setBytesLittleEnd(22, height, head)) { return null;}
        if (!setBytesLittleEnd(34, noOfImgBytes, head)) { return null;}
        byte[] data = new byte[fileSize];
        int pos = 0;
        for (int i = 0; i < head.Length; i++) {
            data[pos++] = (byte)head[i];
        }
        for (int r = 0; r < body.GetLength(0); r++) {
            for (int c = 0; c < body.GetLength(1); c++) {
                data[pos++] = body[r,c];
            }
        }
        return data;
    }

    public static void generateBitmap() {
        int height = 512;
        int width = 1024;
        byte[,] body = genBmpData(height, width, 0xe9967a);
        byte[] data = prepareBmp(body, height, width);
        if (data != null) {
        File.WriteAllBytes("C:\\temp\\NewBitmapCsharp.bmp", data);
            Console.WriteLine("sucess");
        } else {
            Console.WriteLine("error");
        }        
    }
}