#include <stdio.h>
#include <stdlib.h>

typedef struct {
  int x;
  int y;
} coords;

int main() {
  int i = 99;
  int *j;
  j = &i;
  printf("\nWert: %d in Adresse: %d", *j, j);

  coords *p;
  p = malloc(sizeof(coords));
  (*p).x = 10;
  p->y = 20;

  printf("\n Point(%d/%d)", p->x, (*p).y);
  return 0;
}
