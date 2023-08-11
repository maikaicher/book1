#include <stdio.h>
#include <stdlib.h>


int writeText(char* fName, char* content) {
    FILE *fp = fopen(fName, "w");
    if (fp == NULL) {
        return -1;
    }
    fprintf(fp, "%s", content);
    fclose(fp);
    return 0;
}



int main() {
    writeText("C:\\temp\\Hello8.txt", "Hallo, Welt!\nDie 1. Zeile hat zwölf Zeichen.");
    return 0;
}