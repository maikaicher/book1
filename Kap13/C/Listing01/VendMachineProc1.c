#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char* getCan(int selection, double coin) {
  char* output = (char*)malloc(sizeof(char) * 11);
  if (coin!= 1) {
    sprintf(output, "%f", coin);
  } else {
    switch(selection) {
      case 0:
        strcpy(output, "Wasser"); 
        break;
      case 1:
        strcpy(output, "Limonade"); 
        break;
      case 2:
        strcpy(output, "Cola"); 
        break;
    }
  }
  return output;
}

int main() {
  char* vendResult = getCan(1, 1.0);
  printf("\nRueckgabe: %s", vendResult);
  free(vendResult);
  return 0;
}
