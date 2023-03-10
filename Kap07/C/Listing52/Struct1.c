#include <stdio.h>

int main() {
  typedef struct {
    char *name;
    int x;
    int y;
  } player;

  player p1;
  p1.name = "Paul";
  p1.x = 20;
  p1.y = 10;

  printf("%s ist auf (%d/%d)", p1.name, p1.x, p1.y);
  return 0;
};