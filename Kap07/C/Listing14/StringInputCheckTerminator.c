#include <stdio.h>

int main() {
    char eingabe[100];
    scanf("%s", &eingabe);
    printf("\nWert: %s", eingabe);
    printf("\nPos 5: %d", eingabe[5]);

    return 0;
}
