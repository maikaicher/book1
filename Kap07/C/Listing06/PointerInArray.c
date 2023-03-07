#include <stdio.h>

int main() {
    int i[5] = {1, 20, 300, 4000, 50000};
    int *adr;
    adr = &i;
    printf("\nadr.: %d", adr);
    printf("\nWert: %d", *adr);
    adr++;
    printf("\nadr.: %d", adr);
    printf("\nWert: %d", *adr);

    return 0;
}
