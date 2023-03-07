#include <stdio.h>

int main() {
    int punkte[4][2] = {{200, 200}, {600, 200}, {600, 400}, {200, 400}};
    int *adr = &punkte;
    adr++;
    adr++;
    printf("\nWert: %d", *adr);

    return 0;
}
