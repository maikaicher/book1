#include <stdio.h>

int main(int arglength, char* args[]) {
  printf("\n%d", arglength);
  printf("\n%s", args[0]);
  printf("\n%s", args[1]);
  return 0;
}
