#include <stdio.h>

int main() {
    // Listing 1:
    int stundenMo = 8;
    int stundenDi = 7;
    int stundenMi = 10;
    int stundenDo = 6;
    int stundenFr = 4;

    // Listing 2:
    int stundenWoche = stundenMo + stundenDi + stundenMi + stundenDo + stundenFr;
    printf("Wert: %d", stundenWoche);

    // Listing 3 (and usage of array)
    int zahlenArray[5];
    zahlenArray[0] = 8;
    zahlenArray[1] = 7;
    zahlenArray[2] = 10;
    zahlenArray[3] = 6;
    zahlenArray[4] = 4;

    // Listing 4
    int i[5] = {1, 20, 300, 4000, 50000};

    i[3] = -4000;
    printf("\nWert auf 0: %d", i[0]);
    printf("\nWert auf 3: %d", i[3]);

    return 0;
}
