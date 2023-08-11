#include <stdio.h>
#include <stdlib.h>

void readBytes(char *fName, int noOfBytes) {
  int readBytes = 0;
  unsigned char *myBuffer;
  FILE *fp;

  myBuffer = (unsigned char *) malloc(noOfBytes * sizeof(unsigned char));
  fp = fopen(fName,"rb");  
  readBytes = fread(myBuffer, sizeof(unsigned char), noOfBytes, fp);

  fclose(fp);
  for(int i = 0; i < readBytes; i++) {
    printf("\n%02x ", myBuffer[i]);
  }

  free(myBuffer);
}

int main() {
    readBytes("C:\\temp\\MyBitmap.bmp", 100);
    return 0;
}
