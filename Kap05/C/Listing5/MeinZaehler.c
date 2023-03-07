#include <stdio.h>
const int maxwert = 5;
const int schrittweite = 1;
int zaehler = 0;

int main() {
    zaehler = maxwert; 
    do {
        zaehler = zaehler - schrittweite;
      printf("\n%d", zaehler);
    } while (zaehler != 0);
    return 0;
}
