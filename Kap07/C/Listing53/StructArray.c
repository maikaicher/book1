#include <stdio.h>

int main() {
  typedef struct {
    char *name;
    int x;
    int y;
  } player;

  player allPlayer[4];
  allPlayer[0].name = "Paul";
  allPlayer[0].x = 20;
  allPlayer[0].y = 10;

  allPlayer[1].name = "Susi";
  allPlayer[1].x = 40;
  allPlayer[1].y = 30;
    
  printf("\n%s ist auf (%d/%d)", allPlayer[0].name, allPlayer[0].x, allPlayer[0].y);
  printf("\n%s ist auf (%d/%d)", allPlayer[1].name, allPlayer[1].x, allPlayer[1].y);
  return 0;
};