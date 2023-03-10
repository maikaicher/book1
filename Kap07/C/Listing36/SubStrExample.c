#include <stdio.h>

int main() {
  char stringVar[] = "hallo welt";
  char subStringVar[6];
  for (int i = 0; i < 5; i++) {
    subStringVar[i] = stringVar[i];
  }
  subStringVar[5] = 0;
  printf("Wert: %s", subStringVar);
  return 0;
};