#include <stdio.h>

int add(int a, int b) {
  return a + b;
}

int main() {
  int i = add(3, 20);
  printf("Ergebnis = %d", i);
  return 0;
}
