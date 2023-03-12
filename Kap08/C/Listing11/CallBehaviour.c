#include <stdio.h>

void incByValue(int i) {
  i++;
  printf("\nRef 1:%d", i);
}

void incByRef(int *i) {
  (*i)++;
  printf("\nRef 2:%d", *i);
}

int main() {
  int a = 0;
  int b = 0;
  incByValue(a);
  incByRef(&b);
  printf("\nRef 3:%d", a);
  printf("\nRef 4:%d", b);
  return 0;
}
