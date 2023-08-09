#include <stdio.h>

int errorStatus = 0;

int getProzentZahl(int teil, int ganz) {
  if (ganz == 0) {
    errorStatus = -1;
    return 0;
  }
  return (int)(100.0 * teil / ganz);
}

int main() {
  int result = getProzentZahl(10, 20);

  if (errorStatus == 0) {
    printf("Das Ergebnis lautet %d Prozent", result);
  } else {
    printf("Fehler!");
  }
}
