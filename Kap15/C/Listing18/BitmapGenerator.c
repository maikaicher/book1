#include <stdio.h>
#include <stdlib.h>

    unsigned char* genBmpData(int height, int width, int color, int noOfZero, int rowWidth) {
        unsigned char colB = (unsigned char)(color & 0xff);
        unsigned char colG = (unsigned char)((color >> 8) & 0xff);
        unsigned char colR = (unsigned char)((color >> 16) & 0xff);
        unsigned char* body = (unsigned char*)malloc(height*rowWidth);
        for (int r = 0; r < height; r++) {
            int pos = 0;
            for (int c = 0; c < width; c++) {
                body[r * rowWidth + pos++] = colB;
                body[r * rowWidth + pos++] = colG;
                body[r * rowWidth + pos++] = colR;
            }
            for (int c = 0; c < noOfZero; c++) {
            body[r * rowWidth + pos++] = 0x00;
            }
        }
        return body;
    }

    int setBytesLittleEnd(int offset, int value, unsigned char* allBytes, int arrLength) {
    unsigned char writeValue;

    while(value > 0) {
        writeValue = (unsigned char)(value & 0xff);
        allBytes[offset++] = writeValue;
        value >>= 8;
        if (offset >= arrLength) {
            return 0;
        }
    }
    return 1;
}

        unsigned char* prepareBmp(unsigned char* body, int height, int width, int fileSize, int noOfImgBytes, int rowWidth) {
        unsigned char head[0x36] = {
            0x42, 0x4d, // ASCII für BM 
            0x00, 0x00, 0x00, 0x00, // Dateigröße
            0x00, 0x00, 0x00, 0x00, // immer 00
            0x36, 0x00, 0x00, 0x00, // Offset Bilddaten
            0x28, 0x00, 0x00, 0x00, // Größe Infoheader
            0x00, 0x00, 0x00, 0x00, // Breite
            0x00, 0x00, 0x00, 0x00, // Höhe
            0x01, 0x00, // immer 01 00 
            0x18, 0x00, // Farbtiefe
            0x00, 0x00, 0x00, 0x00, // keine Komprimierung
            0x00, 0x00, 0x00, 0x00, // Größe Bilddaten
            0x00, 0x00, 0x00, 0x00, // Aufl. Hor. Standard 00
            0x00, 0x00, 0x00, 0x00, // Aufl. Vert. Standard 00
            0x00, 0x00, 0x00, 0x00, // Farbtabelleninfo 00
            0x00, 0x00, 0x00, 0x00 // Farbtabelleninfo 00
        };

        if (!setBytesLittleEnd(2, fileSize, head, 0x36)) { return 0;}
        if (!setBytesLittleEnd(18, width, head, 0x36)) { return 0;}
        if (!setBytesLittleEnd(22, height, head, 0x36)) { return 0;}
        if (!setBytesLittleEnd(34, noOfImgBytes, head, 0x36)) { return 0;}
        unsigned char* data = (unsigned char*) malloc(fileSize);
        int pos = 0;
        for (int i = 0; i < 0x36; i++) {
            data[pos++] = head[i];
        }
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < rowWidth; c++) {
                data[pos++] = body[r * rowWidth + c];
            }
        }
        return data;
    }

int main() {
  int height = 512;
  int width = 1024;
  int noOfZero = (4 - ((3*width) % 4)) % 4;
  int rowWidth = 3 * width + noOfZero;
  int noOfImgBytes = height * rowWidth;
  int fileSize = 0x36 + noOfImgBytes;
  unsigned char* body = genBmpData(height, width, 0xe9967a, noOfZero, rowWidth);
  unsigned char* data = prepareBmp(body, height, width, fileSize, noOfImgBytes, rowWidth);
  FILE *fp;
  fp = fopen( "C:\\temp\\NewBitmapC.bmp" , "wb" );
  fwrite(data, fileSize, 1, fp);
  fclose(fp);
  free(body);
  free(data);
}


