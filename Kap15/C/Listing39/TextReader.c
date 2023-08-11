#include <stdio.h>
#include <stdlib.h>

const int MAXBYTE = 1024;

int readText(char* fName) {
  FILE *fp = fopen(fName, "r");
  if (fp == NULL) {
    return -1;
  }
  const int MAXBYTE = 512;
  char buffer[MAXBYTE];
  while (fgets(buffer, MAXBYTE, fp)) {
    printf("%s", buffer);
  }
  fclose(fp);
}


int main() {
    readText("C:\\temp\\Hello.txt");
    return 0;
}