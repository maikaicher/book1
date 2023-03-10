#include <stdio.h>
#include <stdlib.h>

typedef struct elmt {
  char* sPayload;
  struct elmt *next;
}  element;

int main() {
  element *el0;
  el0 = (element*) malloc(sizeof(element));
  el0->sPayload = "erstes Element";
  el0->next = NULL;

  element *el1;
  el1 = (element*) malloc(sizeof(element));
  el1->sPayload = "zweites Element";
  el1->next = NULL;
  el0->next = el1;

  element *el2;
  el2 = (element*) malloc(sizeof(element));
  el2->sPayload = "drittes Element";
  el2->next = NULL;
  el1->next = el2;

  element *myEl;
  myEl = el0;

  while (myEl != NULL) {
    printf("\n%s", myEl->sPayload);
    myEl = myEl->next;
  }

  return 0;
}
