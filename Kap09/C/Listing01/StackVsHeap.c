#include <stdio.h>
#include <stdlib.h>

int *myVar;

void createIntStack() {
  int iStack = 123;
  myVar = &iStack;
}

void createIntHeap() {
  int *iHeap;
  iHeap = (int *) malloc(sizeof(int));
  *iHeap = 123;
  myVar = iHeap;
}

void fillMemory() {
  int iArray[100];
  for (int i = 0; i < 100; i++) {
    iArray[i] = -1;
  }
}

int main() {
  createIntStack();
  fillMemory();
  printf("\nWert: %d", *myVar);
  return 0;
}
