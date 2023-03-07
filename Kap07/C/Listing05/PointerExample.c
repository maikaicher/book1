#include <stdio.h>

int main() {
    int zahlVariable = 10;
    int *zahlAdresse = &zahlVariable;
    printf("\nWert Variable: %d", zahlVariable);
    printf("\nAdresse Variable: %d", zahlAdresse);
    printf("\nWert Adresse: %d", *zahlAdresse);

    return 0;
}
